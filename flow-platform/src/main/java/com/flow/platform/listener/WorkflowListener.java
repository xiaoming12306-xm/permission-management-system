package com.flow.platform.listener;

import com.flow.platform.entity.FormData;
import com.flow.platform.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkflowListener {

    @Autowired
    private WeChatService weChatService;

    public void onFormSubmitted(FormData formData) {
        // 发送通知给提交人
        weChatService.sendMessage(formData.getSubmitUser().toString(), "您的表单已提交，等待审批");
    }

    public void onFormApproved(FormData formData) {
        // 发送通知给提交人
        weChatService.sendMessage(formData.getSubmitUser().toString(), "您的表单已通过审批");
    }

    public void onFormRejected(FormData formData) {
        // 发送通知给提交人
        weChatService.sendMessage(formData.getSubmitUser().toString(), "您的表单已被拒绝");
    }
}