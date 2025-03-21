package com.flow.platform.service.impl;

import com.flow.platform.entity.User;
import com.flow.platform.payload.request.LoginRequest;
import com.flow.platform.payload.request.SignupRequest;
import com.flow.platform.payload.response.JwtResponse;
import com.flow.platform.security.JwtUtils;
import com.flow.platform.service.AuthService;
import com.flow.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return new JwtResponse(jwt,null,"","",null);
    }

    @Override
    public void registerUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        userService.createUser(user);
    }
}