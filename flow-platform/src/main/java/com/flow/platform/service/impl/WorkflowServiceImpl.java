package com.flow.platform.service.impl;

import com.flow.platform.entity.FormData;
import com.flow.platform.entity.ApprovalFlow;
import com.flow.platform.service.ApprovalRecordService;
import com.flow.platform.entity.ApprovalRecord;
import com.flow.platform.service.FormDataService;
import com.flow.platform.service.WeChatService;
import com.flow.platform.service.WorkflowService;
import com.flow.platform.service.ApprovalFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    private FormDataService formDataService;

    @Autowired
    private ApprovalFlowService approvalFlowService;

    @Autowired
    private ApprovalRecordService approvalRecordService;

    @Autowired
    private WeChatService weChatService;

    @Override
    public void startApprovalProcess(FormData formData, ApprovalFlow flow) {
        // 更新表单状态为“审批中”
        formData.setCurrentStatus("审批中");
        formDataService.updateFormData(formData.getFormId(), formData);

        // 发送通知给审批人
        weChatService.sendApprovalNotification(flow.getApprovers().get(0), formData.getFormId().toString());

/*        // 发送通知给第一个审批人
        Long firstApprover = flow.getApprovers().get(0);
        weChatService.sendApprovalNotification(firstApprover, formData.getFormId().toString());*/
    }

    @Override
    public void approveForm(Long formId, Long userId, String comment) {
        // 更新表单状态为“已通过”
        FormData formData = formDataService.getFormDataById(formId);
        formData.setCurrentStatus("已通过");
        formDataService.updateFormData(formId, formData);

        // 记录审批结果
        ApprovalRecord record = new ApprovalRecord(formId, userId, true, comment);
        approvalRecordService.createRecord(record);
    }

    @Override
    public void rejectForm(Long formId, Long userId, String comment) {
        // 更新表单状态为“已拒绝”
        FormData formData = formDataService.getFormDataById(formId);
        formData.setCurrentStatus("已拒绝");
        formDataService.updateFormData(formId, formData);

        // 记录审批结果
        ApprovalRecord record = new ApprovalRecord(formId, userId, false, comment);
        approvalRecordService.createRecord(record);
    }
}