package com.example.permissionsystem.controller;

import com.example.permissionsystem.security.JwtRequest;
import com.example.permissionsystem.security.JwtResponse;
import com.example.permissionsystem.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private JwtUtil jwtUtil;

  @Autowired private UserDetailsService userDetailsService;

  @PostMapping("/login")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
      throws Exception {
    System.out.println(
        authenticationRequest.getUsername() + " + " + authenticationRequest.getPassword());
    try {
      // 验证用户名和密码
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequest.getUsername(), authenticationRequest.getPassword()));

      // 生成 JWT
      final UserDetails userDetails =
          userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
      final String jwt = jwtUtil.generateToken(userDetails);

      // 返回 JWT
      return ResponseEntity.ok(new JwtResponse(jwt));
    } catch (Exception e) {
      logger.error("登录失败：", e);
      return ResponseEntity.status(403).body("登录失败：" + e.getMessage());
    }
  }
}
