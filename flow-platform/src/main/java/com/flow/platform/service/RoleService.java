package com.flow.platform.service;

import com.flow.platform.entity.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long roleId);
    Role createRole(Role role);
    Role updateRole(Long roleId, Role role);
    void deleteRole(Long roleId);
}