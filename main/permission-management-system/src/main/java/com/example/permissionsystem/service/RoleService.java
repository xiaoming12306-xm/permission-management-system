package com.example.permissionsystem.service;

import com.example.permissionsystem.model.Role;
import com.example.permissionsystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired private RoleRepository roleRepository;

  public Role findByName(String name) {
    return roleRepository.findByName(name);
  }

  public Role save(Role role) {
    return roleRepository.save(role);
  }
}
