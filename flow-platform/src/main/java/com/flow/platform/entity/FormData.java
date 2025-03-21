package com.flow.platform.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Data
public class FormData {
    private Long formId;       // 表单ID
    private String formType;   // 表单类型
    private String formData;   // 表单数据（JSON格式）
    private Long submitUser;   // 提交人ID
    private String currentStatus; // 当前状态
    private Date createTime;   // 创建时间
    private Date updateTime;   // 更新时间

}