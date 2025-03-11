package com.workflow.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String username;
    private String realName;
    
    public LoginResponse(String token, String username, String realName) {
        this.token = token;
        this.username = username;
        this.realName = realName;
    }
} 