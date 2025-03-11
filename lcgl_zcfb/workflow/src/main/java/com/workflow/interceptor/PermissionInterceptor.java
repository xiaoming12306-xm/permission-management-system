package com.workflow.interceptor;

import com.workflow.annotation.RequiresPermission;
import com.workflow.annotation.Logical;
import com.workflow.exception.NoLoginException;
import com.workflow.exception.NoPermissionException;
import com.workflow.service.SysPermissionService;
import com.workflow.util.SecurityUtils;
import com.workflow.security.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
    
    @Autowired
    private SysPermissionService permissionService;
    
    @SuppressWarnings({ "null", "unused" })
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        RequiresPermission requiresPermission = handlerMethod.getMethodAnnotation(RequiresPermission.class);
        if (requiresPermission == null) {
            return true;
        }
        
        String permissionCode = requiresPermission.value();
        Logical logical = requiresPermission.logical();
        
        // 获取当前登录用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser == null) {
            throw new NoLoginException("用户未登录");
        }
        
        // 验证权限
        boolean hasPermission = permissionService.hasPermission(loginUser.getId(), permissionCode);
        if (!hasPermission) {
            throw new NoPermissionException("没有操作权限");
        }
        
        return true;
    }
} 