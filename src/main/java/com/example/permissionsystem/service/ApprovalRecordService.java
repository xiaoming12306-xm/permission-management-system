package com.example.permissionsystem.service;

import com.example.permissionsystem.model.ApprovalRecord;
import com.example.permissionsystem.repository.ApprovalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalRecordService {
  @Autowired private ApprovalRecordRepository approvalRecordRepository;

  public ApprovalRecord save(ApprovalRecord approvalRecord) {
    return approvalRecordRepository.save(approvalRecord);
  }
}
