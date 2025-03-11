package com.workflow.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Configuration
public class JwtConfig {
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey secretKey;

    public SecretKey getSecretKey() {
        if (secretKey == null) {
            // 使用 Keys.secretKeyFor 生成安全的密钥
            secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }
        return secretKey;
    }

    public Long getExpiration() {
        return expiration;
    }
} 