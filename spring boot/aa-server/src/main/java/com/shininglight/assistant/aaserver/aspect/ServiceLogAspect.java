package com.shininglight.assistant.aaserver.aspect;
import com.shininglight.assistant.aaserver.entity.business.AspectObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 16:27 12/06/18
 */
@Aspect
@Component
@Slf4j
public class ServiceLogAspect {


    @Pointcut("execution(public * com.shininglight.assistant.aaserver.service.impl.*.*(..))")
    public void serviceLog() {
    }

    @Around("serviceLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("before sevice log AOP,\n" +
                 "class:  " + joinPoint.getTarget().getClass().getName() + ",\n" +
                 "method: " + joinPoint.getSignature().getName() + ",\n" +
                 "param:  " + new AspectObject(joinPoint.getArgs()).toString() + "\n");


        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("after sevice log AOP,\n"+
                 "class:  " + joinPoint.getTarget().getClass().getName() + ",\n" +
                 "method: " + joinPoint.getSignature().getName() + ",\n" +
                 "cost:   " + (end - start) + "ms" + ",\n" +
                 "result: " + result.toString() + "\n");
        return result;
    }
}
