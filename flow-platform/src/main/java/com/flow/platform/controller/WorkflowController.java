package com.flow.platform.controller;

import com.flow.platform.entity.FormData;
import com.flow.platform.entity.ApprovalFlow;
import com.flow.platform.service.WorkflowService;
import com.flow.platform.service.ApprovalFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private ApprovalFlowService approvalFlowService;

    @PostMapping("/start")
    public void startApprovalProcess(@RequestBody FormData formData, @RequestParam Long flowId) {
        ApprovalFlow flow = approvalFlowService.getFlowById(flowId);
        workflowService.startApprovalProcess(formData, flow);
    }

    @PostMapping("/approve")
    public void approveForm(@RequestParam Long formId, @RequestParam Long userId, @RequestParam String comment) {
        workflowService.approveForm(formId, userId, comment);
    }

    @PostMapping("/reject")
    public void rejectForm(@RequestParam Long formId, @RequestParam Long userId, @RequestParam String comment) {
        workflowService.rejectForm(formId, userId, comment);
    }
}