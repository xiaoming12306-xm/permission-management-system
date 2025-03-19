package com.flow.platform.service;

import com.flow.platform.entity.FormData;
import com.flow.platform.entity.ApprovalFlow;

public interface WorkflowService {
    void startApprovalProcess(FormData formData, ApprovalFlow flow);
    void approveForm(Long formId, Long userId, String comment);
    void rejectForm(Long formId, Long userId, String comment);
}