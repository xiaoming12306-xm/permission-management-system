package com.example.permissionsystem.controller;

import com.example.permissionsystem.model.User;
import com.example.permissionsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired private UserService userService;

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.save(user);
  }

  @GetMapping("/{username}")
  public User getUser(@PathVariable String username) {
    return userService.findByUsername(username);
  }
}
