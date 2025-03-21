package com.flow.platform.aspect;

import com.flow.platform.exception.PermissionDeniedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class PermissionAspect {

    @Before("@annotation(com.flow.platform.aspect.RequiresPermissions)")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);

        // 获取权限标识
        String[] permissions = requiresPermissions.value();

        // 检查用户是否拥有权限
        if (!SecurityUtils.hasPermissions(permissions)) {
            throw new PermissionDeniedException("权限不足");
        }
    }
}