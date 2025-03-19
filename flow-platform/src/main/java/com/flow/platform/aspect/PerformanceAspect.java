package com.flow.platform.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Pointcut("execution(* com.flow.platform.service.*.*(..))")
    public void servicePointCut() {}

    @Around("servicePointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 计算方法执行时间
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // 记录性能日志
        logger.info("方法 {} 执行耗时: {} ms", joinPoint.getSignature().getName(), executionTime);

        return result;
    }
}