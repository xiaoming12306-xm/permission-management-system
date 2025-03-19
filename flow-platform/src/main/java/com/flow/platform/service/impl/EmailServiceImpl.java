package com.flow.platform.service.impl;

import com.flow.platform.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    @Override
    public void sendApprovalEmail(List<Long> approvers, String formId) {
        String subject = "新的审批请求";
        String text = "您有一个新的审批请求，表单ID：" + formId;
        approvers.forEach(approver -> {
            String email = userService.getUserById(approver).getEmail();
            sendSimpleMessage(email, subject, text);
        });
    }
}