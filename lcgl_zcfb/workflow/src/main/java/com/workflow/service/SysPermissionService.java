package com.workflow.service;

import com.workflow.entity.SysPermission;
import java.util.List;

public interface SysPermissionService {
    /**
     * 判断用户是否具有某个权限
     */
    boolean hasPermission(Long userId, String permissionCode);
    
    /**
     * 获取用户的所有权限
     */
    List<SysPermission> getUserPermissions(Long userId);
    
    /**
     * 获取角色的所有权限
     */
    List<SysPermission> getRolePermissions(Long roleId);

    /**
     * 为角色分配权限
     * @param roleId 角色ID
     * @param permissionIds 权限ID列表
     */
    void assignPermissions(Long roleId, List<Long> permissionIds);
} 