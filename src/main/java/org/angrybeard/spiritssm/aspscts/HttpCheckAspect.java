package org.angrybeard.spiritssm.aspscts;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritssm.bo.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by angry_beary on 2019/7/1.
 */
@Slf4j
@Aspect
@Component
public class HttpCheckAspect {

    @Pointcut("@annotation(org.angrybeard.spiritssm.annotation.AutoChecker)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = getUserToken(request);
        if (!"123456".equals(token)) {
            log.error("check unpass,name={}", joinPoint.getArgs()[0]);
            return joinPoint.proceed();
            //return BaseResponse.badRequst();
        }
        return joinPoint.proceed();
    }

    private String getUserToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("user_token")) {
                return cookie.getValue();
            }
        }
        return "";
    }

}
