package com.flow.platform.controller;

import com.flow.platform.service.ApprovalFlowService;
import com.flow.platform.entity.ApprovalFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approval-flows")
public class ApprovalFlowController {

    @Autowired
    private ApprovalFlowService approvalFlowService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ApprovalFlow>> getAllFlows() {
        return ResponseEntity.ok(approvalFlowService.getAllFlows());
    }

    @GetMapping("/{flowId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApprovalFlow> getFlowById(@PathVariable Long flowId) {
        return ResponseEntity.ok(approvalFlowService.getFlowById(flowId));
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApprovalFlow> createFlow(@RequestBody ApprovalFlow flow) {
        return ResponseEntity.ok(approvalFlowService.createFlow(flow));
    }

    @PutMapping("/{flowId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApprovalFlow> updateFlow(@PathVariable Long flowId, @RequestBody ApprovalFlow flow) {
        return ResponseEntity.ok(approvalFlowService.updateFlow(flowId, flow));
    }

    @DeleteMapping("/{flowId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFlow(@PathVariable Long flowId) {
        approvalFlowService.deleteFlow(flowId);
        return ResponseEntity.noContent().build();
    }
}