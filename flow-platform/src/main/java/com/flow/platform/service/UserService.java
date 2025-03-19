package com.flow.platform.service;

import com.flow.platform.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    User findByUsername(String username);
}