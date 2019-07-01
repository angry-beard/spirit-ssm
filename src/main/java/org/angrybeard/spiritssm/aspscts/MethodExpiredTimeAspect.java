package org.angrybeard.spiritssm.aspscts;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by angry_beary on 2019/7/2.
 */
@Slf4j
@Aspect
@Component
public class MethodExpiredTimeAspect {

    @Pointcut("within(org.angrybeard.spiritssm.controller.UserController)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object methodExpiredTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();
        sendMethodExpiredTime(joinPoint.getSignature().toLongString(), stopWatch.getTotalTimeMillis());
        return retVal;
    }

    private void sendMethodExpiredTime(String method, double totalTimeSeconds) {
        log.info("method {} invoked,expired time:{} ms", method, totalTimeSeconds);
    }
}
