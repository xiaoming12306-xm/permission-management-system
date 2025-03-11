package com.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalService {

    @Autowired
    private WeChatService weChatService;

    public void approveForm(Long formId, Long approverId) {
        // 审批逻辑
        // ...

        // 发送企业微信提醒
        String message = "您有一个新的审批请求，请及时处理。";
        weChatService.sendMessage("zhangsan", message); // 这里的"zhangsan"是企业微信的用户ID
    }
} 