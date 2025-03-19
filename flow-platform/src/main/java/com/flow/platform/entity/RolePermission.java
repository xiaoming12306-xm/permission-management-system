package com.flow.platform.entity;

import lombok.Data;

@Data
public class RolePermission {
    private Long roleId; // 角色ID
    private Long permId; // 权限ID

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }
}