package com.flow.platform.aspect;

import com.flow.platform.entity.Log;
import com.flow.platform.service.LogService;
import com.flow.platform.aspect.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.flow.platform.annotation.Log)")
    public void logPointCut() {}

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录方法调用前的日志
        Log log = new Log();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 设置操作用户
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.setUsername(username);

        // 设置操作描述
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.flow.platform.annotation.Log logAnnotation = method.getAnnotation(com.flow.platform.annotation.Log.class);
        if (logAnnotation != null) {
            log.setOperation(logAnnotation.value());
        }

        // 设置请求方法
        log.setMethod(request.getMethod());

        // 设置请求参数
        log.setParams(getParams(joinPoint));

        // 设置IP地址
        log.setIp(IpUtils.getIpAddr(request));

        // 设置操作时间
        log.setCreateTime(new Date());

        // 保存日志
        logService.save(log);
    }

    private String getParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder params = new StringBuilder();
        for (Object arg : args) {
            params.append(arg.toString()).append(" ");
        }
        return params.toString();
    }
}