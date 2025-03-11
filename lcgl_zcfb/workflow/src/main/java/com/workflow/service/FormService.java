package com.workflow.service;

import com.workflow.dto.FormSubmitDTO;
import com.workflow.dto.ApprovalDTO;
import java.util.Map;

public interface FormService {
    /**
     * 提交表单
     * @param formData 表单数据
     * @return 提交结果
     */
    Map<String, Object> submitForm(FormSubmitDTO formData);

    /**
     * 获取表单列表
     * @param status 表单状态
     * @param page 页码
     * @param size 每页大小
     * @return 表单列表
     */
    Map<String, Object> getFormList(String status, Integer page, Integer size);

    /**
     * 审批表单
     * @param approvalData 审批数据
     */
    void approveForm(ApprovalDTO approvalData);
} 