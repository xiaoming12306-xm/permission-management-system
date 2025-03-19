package com.flow.platform.service.impl;

import com.flow.platform.entity.Permission;
import com.flow.platform.repository.PermissionRepository;
import com.flow.platform.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Long permId) {
        return permissionRepository.findById(permId)
            .orElseThrow(() -> new RuntimeException("权限未找到"));
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission updatePermission(Long permId, Permission permission) {
        Permission existingPermission = getPermissionById(permId);
        existingPermission.setPermName(permission.getPermName());
        existingPermission.setPermKey(permission.getPermKey());
        return permissionRepository.save(existingPermission);
    }

    @Override
    public void deletePermission(Long permId) {
        permissionRepository.deleteById(permId);
    }
}