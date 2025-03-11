package com.workflow.controller;
/* 
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
*/

import com.workflow.config.JwtConfig;
import com.workflow.dto.LoginRequest;
import com.workflow.dto.LoginResponse;
import com.workflow.entity.SysUser;
import com.workflow.service.SysUserService;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private SysUserService userService;
    
    @Autowired
    private JwtConfig jwtConfig;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        logger.info("开始登录，用户名：{}", request.getUsername());
        try {
            // 打印请求内容
            logger.debug("登录请求内容：{}", request);
            
            // 查找用户
            SysUser user = userService.findByUsername(request.getUsername());
            if (user == null) {
                logger.warn("用户不存在：{}", request.getUsername());
                return ResponseEntity.status(401).body("用户不存在");
            }

            // 验证密码
            if (!userService.validatePassword(request.getPassword(), user.getPassword())) {
                logger.warn("密码错误：{}", request.getUsername());
                return ResponseEntity.status(401).body("密码错误");
            }

            // 生成token
            String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpiration()))
                    .signWith(jwtConfig.getSecretKey())
                    .compact();

            logger.info("用户 {} 登录成功，生成token", user.getUsername());

            // 返回登录响应
            LoginResponse response = new LoginResponse(token, user.getUsername(), user.getRealName());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("登录失败：", e);
            return ResponseEntity.status(500).body("系统错误，请稍后重试");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // 由于使用JWT，后端不需要特殊处理，前端删除token即可
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String token) {
        try {
            // 从token中获取用户名
            String username = Jwts.parserBuilder()
                    .setSigningKey(jwtConfig.getSecretKey())
                    .build()
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();

            // 查找用户信息
            SysUser user = userService.findByUsername(username);
            if (user == null) {
                return ResponseEntity.badRequest().body("用户不存在");
            }

            // 返回用户信息
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("获取用户信息失败：", e);
            return ResponseEntity.badRequest().body("获取用户信息失败");
        }
    }

  /* 
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
      // final String jwt = jwtUtil.generateToken(userDetails);

      // 返回 JWT
      // return ResponseEntity.ok(new JwtResponse(jwt));
    } catch (Exception e) {
      logger.error("登录失败：", e);
      return ResponseEntity.status(403).body("登录失败：" + e.getMessage());
    }
  }
    */
}
