package com.flow.platform.entity;

import lombok.Data;
import java.util.Date;

@Data
public class FormData {
    private Long formId;       // 表单ID
    private String formType;   // 表单类型
    private String formData;   // 表单数据（JSON格式）
    private Long submitUser;   // 提交人ID
    private String currentStatus; // 当前状态
    private Date createTime;   // 创建时间
    private Date updateTime;   // 更新时间

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }

    public Long getSubmitUser() {
        return submitUser;
    }

    public void setSubmitUser(Long submitUser) {
        this.submitUser = submitUser;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
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