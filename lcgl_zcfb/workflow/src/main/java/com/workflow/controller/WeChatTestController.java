package com.workflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.workflow.service.WeChatService;

@RestController
@RequestMapping("/api/wechat")
public class WeChatTestController {

    @Autowired
    private WeChatService weChatService;

    @GetMapping("/test")
    public String testWeChat() {
        try {
            // 获取AccessToken
            String accessToken = weChatService.getAccessToken();
            // 这里可以调用企业微信的API获取用户信息
            // 例如：获取部门列表、用户列表等
            return "AccessToken: " + accessToken;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/user/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        try {
            String userInfo = weChatService.getUserInfo(userId);
            return "User Info: " + userInfo;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}