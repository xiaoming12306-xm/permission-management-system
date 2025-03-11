package com.workflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.workflow.service.FormService;
import com.workflow.dto.FormSubmitDTO;
import com.workflow.dto.ApprovalDTO;
import com.workflow.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/form")
@Api(tags = "表单管理接口")
public class FormController {
    
    @Autowired
    private FormService formService;
    
    @SuppressWarnings("rawtypes")
    @PostMapping("/submit")
    @ApiOperation("提交表单")
    public Result submitForm(@RequestBody FormSubmitDTO formData) {
        try {
            return Result.success(formService.submitForm(formData));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/list")
    @ApiOperation("获取表单列表")
    public Result getFormList(@RequestParam(required = false) String status,
                            @RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer size) {
        return Result.success(formService.getFormList(status, page, size));
    }
    
    @SuppressWarnings("rawtypes")
    @PostMapping("/approve")
    @ApiOperation("审批表单")
    public Result approveForm(@RequestBody ApprovalDTO approvalData) {
        try {
            formService.approveForm(approvalData);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
} 