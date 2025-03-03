package com.example.permissionsystem.service;

import com.example.permissionsystem.model.User;
import com.example.permissionsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private UserRepository userRepository;

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    return new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(), user.getAuthorities());

    // 模拟从数据库加载用户信息
    /*    if ("admin".equals(username)) {
      return User.withUsername("admin")
          .password(passwordEncoder.encode("password")) // 加密密码
          .roles("USER")
          .build();
    } else {
      throw new UsernameNotFoundException("用户未找到: " + username);
    }*/
  }
}
