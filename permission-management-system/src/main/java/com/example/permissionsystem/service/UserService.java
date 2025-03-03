package com.example.permissionsystem.service;

import com.example.permissionsystem.model.User;
import com.example.permissionsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}
