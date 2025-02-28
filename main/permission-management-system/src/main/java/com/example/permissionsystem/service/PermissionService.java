package com.example.permissionsystem.service;

import com.example.permissionsystem.model.Permission;
import com.example.permissionsystem.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
  @Autowired private PermissionRepository permissionRepository;

  public Permission findByName(String name) {
    return permissionRepository.findByName(name);
  }

  public Permission save(Permission permission) {
    return permissionRepository.save(permission);
  }
}
