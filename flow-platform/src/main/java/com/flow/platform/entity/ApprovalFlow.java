package com.flow.platform.entity;

import lombok.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
public class ApprovalFlow {
    private Long flowId;          // 流程ID
    private String formType;      // 表单类型
    private String flowName;      // 流程名称
    private String configJson;    // 流程配置（JSON格式）
    private List<Long> approvers; // 审批人列表
    private Date createTime;      // 创建时间
    private Date updateTime;      // 更新时间

}