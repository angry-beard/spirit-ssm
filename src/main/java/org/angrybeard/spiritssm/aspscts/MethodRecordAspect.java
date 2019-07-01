package org.angrybeard.spiritssm.aspscts;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by angry_beary on 2019/7/1.
 */
@Slf4j
@Aspect
@Component
public class MethodRecordAspect {

    @Pointcut("within(org.angrybeard.spiritssm.controller.UserController)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void logMehtodInvokeParam(JoinPoint joinPoint) {
        log.info("Before menthod {} invoke,param:{}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "pointcut()", returning = "obj")
    public void logMethodInvokeResult(JoinPoint joinPoint, Object obj) {
        log.info("After method {} invoke,result:{}", joinPoint.getSignature().toShortString(), JSONObject.toJSONString(obj));
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public void logMethodInvokeException(JoinPoint joinPoint, Exception exception) {
        log.info("method {} invoke exception:{}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}
