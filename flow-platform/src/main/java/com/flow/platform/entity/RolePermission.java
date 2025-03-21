package com.flow.platform.entity;

import lombok.*;

@Getter
@Setter
@Data
public class RolePermission {
    private Long roleId; // 角色ID
    private Long permId; // 权限ID
}