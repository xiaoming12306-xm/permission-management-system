package com.example.permissionsystem.controller;

import com.example.permissionsystem.model.Role;
import com.example.permissionsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

  @Autowired private RoleService roleService;

  @PostMapping
  public Role createRole(@RequestBody Role role) {
    return roleService.save(role);
  }

  @GetMapping("/{name}")
  public Role getRole(@PathVariable String name) {
    return roleService.findByName(name);
  }
}
