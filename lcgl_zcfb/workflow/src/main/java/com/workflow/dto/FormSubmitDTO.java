package com.workflow.dto;

import lombok.Data;
import java.util.Map;

@Data
public class FormSubmitDTO {
    /**
     * 表单ID
     */
    private String formId;
    
    /**
     * 表单类型
     */
    private String formType;
    
    /**
     * 表单数据
     */
    private Map<String, Object> formData;
    
    /**
     * 提交人ID
     */
    private String submitterId;
    
    /**
     * 提交人姓名
     */
    private String submitterName;
} 