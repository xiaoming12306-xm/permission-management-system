package com.workflow.service.impl;

import com.workflow.entity.SysUser;
import com.workflow.entity.SysRole;
import com.workflow.entity.SysPermission;
import com.workflow.mapper.SysUserMapper;
import com.workflow.mapper.SysRoleMapper;
import com.workflow.mapper.SysPermissionMapper;
import com.workflow.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    
    @Autowired
    private SysUserMapper userMapper;
    
    @Autowired
    private SysRoleMapper roleMapper;
    
    @Autowired
    private SysPermissionMapper permissionMapper;
    
    @Override
    public boolean hasPermission(Long userId, String permissionCode) {
        // 获取用户角色
        List<SysRole> roles = roleMapper.selectRolesByUserId(userId);
        if (CollectionUtils.isEmpty(roles)) {
            return false;
        }
        
        // 获取角色权限
        List<Long> roleIds = roles.stream().map(SysRole::getId).collect(Collectors.toList());
        List<SysPermission> permissions = permissionMapper.selectPermissionsByRoleIds(roleIds);
        
        // 判断是否具有指定权限
        return permissions.stream()
                .anyMatch(permission -> permission.getPermissionCode().equals(permissionCode));
    }
    
    @Override
    public List<SysPermission> getUserPermissions(Long userId) {
        List<SysRole> roles = roleMapper.selectRolesByUserId(userId);
        if (CollectionUtils.isEmpty(roles)) {
            return Collections.emptyList();
        }
        
        List<Long> roleIds = roles.stream().map(SysRole::getId).collect(Collectors.toList());
        return permissionMapper.selectPermissionsByRoleIds(roleIds);
    }
    
    @Override
    public List<SysPermission> getRolePermissions(Long roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void assignPermissions(Long roleId, List<Long> permissionIds) {
        // 先删除角色原有的权限
        permissionMapper.deleteRolePermissions(roleId);
        
        // 如果权限ID列表不为空，则添加新的权限
        if (!CollectionUtils.isEmpty(permissionIds)) {
            permissionMapper.insertRolePermissions(roleId, permissionIds);
        }
    }
}