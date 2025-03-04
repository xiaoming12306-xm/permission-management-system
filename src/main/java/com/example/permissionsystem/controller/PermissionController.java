package com.example.permissionsystem.controller;

import com.example.permissionsystem.model.Permission;
import com.example.permissionsystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

  @Autowired private PermissionService permissionService;

  @PostMapping
  public Permission createPermission(@RequestBody Permission permission) {
    return permissionService.save(permission);
  }

  @GetMapping("/{name}")
  public Permission getPermission(@PathVariable String name) {
    return permissionService.findByName(name);
  }
}
