package com.flow.platform.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ApprovalFlow {
    private Long flowId;          // 流程ID
    private String formType;      // 表单类型
    private String flowName;      // 流程名称
    private String configJson;    // 流程配置（JSON格式）
    private List<Long> approvers; // 审批人列表
    private Date createTime;      // 创建时间
    private Date updateTime;      // 更新时间

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getConfigJson() {
        return configJson;
    }

    public void setConfigJson(String configJson) {
        this.configJson = configJson;
    }

    public List<Long> getApprovers() {
        return approvers;
    }

    public void setApprovers(List<Long> approvers) {
        this.approvers = approvers;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}