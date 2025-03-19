package com.flow.platform.service;

public interface WeChatService {
    void sendMessage(String userId, String message);
    void sendApprovalNotification(Long userId, String formId);
}