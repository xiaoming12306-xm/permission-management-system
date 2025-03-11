package com.workflow.service;

import com.workflow.entity.SysUser;

public interface SysUserService {
    SysUser findByUsername(String username);
    boolean validatePassword(String rawPassword, String encodedPassword);
} 