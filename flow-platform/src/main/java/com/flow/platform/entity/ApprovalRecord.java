package com.flow.platform.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter
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

}