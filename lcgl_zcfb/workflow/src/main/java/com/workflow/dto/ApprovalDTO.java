package com.workflow.dto;

import lombok.Data;

@Data
public class ApprovalDTO {
    /**
     * 表单ID
     */
    private String formId;
    
    /**
     * 审批结果（通过/拒绝）
     */
    private String approvalResult;
    
    /**
     * 审批意见
     */
    private String approvalComment;
    
    /**
     * 审批人ID
     */
    private String approverId;
    
    /**
     * 审批人姓名
     */
    private String approverName;
} 