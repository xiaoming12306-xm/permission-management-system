package com.workflow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        logger.info("测试接口被调用");
        return ResponseEntity.ok("API is working!");
    }

    @GetMapping("/api/test")
    public ResponseEntity<?> authTest() {
        logger.info("Auth测试接口被调用");
        return ResponseEntity.ok("Auth API is working!");
    }
} 