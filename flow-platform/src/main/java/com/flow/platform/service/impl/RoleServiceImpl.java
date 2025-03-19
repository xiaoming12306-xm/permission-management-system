package com.flow.platform.service.impl;

import com.flow.platform.entity.Role;
import com.flow.platform.repository.RoleRepository;
import com.flow.platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId)
            .orElseThrow(() -> new RuntimeException("角色未找到"));
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long roleId, Role role) {
        Role existingRole = getRoleById(roleId);
        existingRole.setRoleName(role.getRoleName());
        existingRole.setRoleKey(role.getRoleKey());
        return roleRepository.save(existingRole);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}