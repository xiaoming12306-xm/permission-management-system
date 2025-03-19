package com.flow.platform.controller;

import com.flow.platform.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wechat")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    @PostMapping("/send-notification")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> sendNotification(@RequestParam Long userId, @RequestParam String message) {
        weChatService.sendMessage(userId.toString(), message);
        return ResponseEntity.ok("通知发送成功");
    }
}