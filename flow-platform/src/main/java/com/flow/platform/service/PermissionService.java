package com.flow.platform.service;

import com.flow.platform.entity.Permission;
import java.util.List;

public interface PermissionService {
    List<Permission> getAllPermissions();
    Permission getPermissionById(Long permId);
    Permission createPermission(Permission permission);
    Permission updatePermission(Long permId, Permission permission);
    void deletePermission(Long permId);
}