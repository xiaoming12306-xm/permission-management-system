package com.example.permissionsystem.controller;

import com.example.permissionsystem.model.ApprovalRecord;
import com.example.permissionsystem.service.ApprovalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalRecordController {

  @Autowired private ApprovalRecordService approvalRecordService;

  @PostMapping
  public ApprovalRecord createApprovalRecord(@RequestBody ApprovalRecord approvalRecord) {
    return approvalRecordService.save(approvalRecord);
  }
}
