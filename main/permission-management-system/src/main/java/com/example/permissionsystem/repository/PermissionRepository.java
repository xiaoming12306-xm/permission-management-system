package com.example.permissionsystem.repository;

import com.example.permissionsystem.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

  Permission findByName(String name);
}
