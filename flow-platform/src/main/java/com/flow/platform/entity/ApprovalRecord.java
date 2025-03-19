package com.flow.platform.entity;

import lombok.Data;
import java.util.Date;

@Data
public class ApprovalRecord {
    private Long recordId;       // 记录ID
    private Long formId;         // 表单ID
    private Long approver;       // 审批人ID
    private Boolean approvalResult; // 审批结果（true:通过, false:拒绝）
    private String approvalOpinion; // 审批意见
    private Date approvalTime;   // 审批时间

    public ApprovalRecord(Long formId, Long userId, boolean b, String comment) {
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getApprover() {
        return approver;
    }

    public void setApprover(Long approver) {
        this.approver = approver;
    }

    public Boolean getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(Boolean approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }
}