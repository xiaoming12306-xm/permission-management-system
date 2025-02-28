package com.example.permissionsystem.service;

// import com.example.permissionsystem.model.User;
import com.example.permissionsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    /*    User user = userRepository.findByUsername(username);
      if (user == null) {
        throw new UsernameNotFoundException("User not found with username: " + username);
      }
      return new org.springframework.security.core.userdetails.User(
          user.getUsername(), user.getPassword(), user.getAuthorities());
    }*/

    // 模拟从数据库加载用户信息
    if ("admin".equals(username)) {
      return User.withUsername("admin")
          .password("$2a$10$EblZqNptyY8Z6X6g7pQz.e8z6Z7q7z6Z7q7z6Z7q7z6Z7q7z6Z7q7")
          .roles("USER")
          .build(); // 密码为 "password"
    } else {
      throw new UsernameNotFoundException("用户未找到: " + username);
    }
  }
}
