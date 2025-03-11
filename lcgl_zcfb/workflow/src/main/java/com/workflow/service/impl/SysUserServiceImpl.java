package com.workflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.workflow.entity.SysUser;
import com.workflow.mapper.SysUserMapper;
import com.workflow.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class SysUserServiceImpl implements SysUserService {
    
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
    
    @Autowired
    private SysUserMapper userMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void init() {
        try {
            // 删除现有的admin用户
            QueryWrapper<SysUser> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("username", "admin");
            userMapper.delete(deleteWrapper);
            
            // 创建新的admin用户
            SysUser adminUser = new SysUser();
            adminUser.setUsername("admin");
            String encodedPassword = passwordEncoder.encode("123456");
            logger.info("创建admin用户，加密后的密码: {}", encodedPassword);
            adminUser.setPassword(encodedPassword);
            adminUser.setRealName("管理员");
            adminUser.setEmail("admin@example.com");
            adminUser.setMobile("13800138000");
            adminUser.setStatus(1);
            adminUser.setCreateTime(new Date());
            
            userMapper.insert(adminUser);
            logger.info("成功创建admin用户");
        } catch (Exception e) {
            logger.error("初始化admin用户失败:", e);
        }
    }
    
    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectOne(wrapper);
    }
    
    @Override
    public boolean validatePassword(String rawPassword, String encodedPassword) {
        logger.debug("验证密码 - 原始密码: {}, 加密密码: {}", rawPassword, encodedPassword);
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        logger.debug("密码验证结果: {}", matches);
        return matches;
    }
} 