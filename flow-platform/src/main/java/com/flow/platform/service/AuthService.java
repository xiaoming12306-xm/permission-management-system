package com.flow.platform.service;

import com.flow.platform.payload.request.LoginRequest;
import com.flow.platform.payload.request.SignupRequest;
import com.flow.platform.payload.response.JwtResponse;

public interface AuthService {
    JwtResponse authenticateUser(LoginRequest loginRequest);
    void registerUser(SignupRequest signupRequest);
}