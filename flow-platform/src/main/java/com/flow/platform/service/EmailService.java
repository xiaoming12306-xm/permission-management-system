package com.flow.platform.service;

import java.util.List;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
    void sendApprovalEmail(List<Long> approvers, String formId);
}