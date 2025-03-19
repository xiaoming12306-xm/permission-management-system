package com.flow.platform.service.impl;

import com.flow.platform.repository.ApprovalRecordRepository;
import com.flow.platform.service.ApprovalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flow.platform.entity.ApprovalRecord;
import java.util.List;

@Service
public class ApprovalRecordServiceImpl implements ApprovalRecordService {

    @Autowired
    private ApprovalRecordRepository approvalRecordRepository;

    @Override
    public List<ApprovalRecord> getAllRecords() {
        return approvalRecordRepository.findAll();
    }

    @Override
    public ApprovalRecord getRecordById(Long recordId) {
        return approvalRecordRepository.findById(recordId)
            .orElseThrow(() -> new RuntimeException("审批记录未找到"));
    }

    @Override
    public ApprovalRecord createRecord(ApprovalRecord record) {
        return approvalRecordRepository.save(record);
    }

    @Override
    public ApprovalRecord updateRecord(Long recordId, ApprovalRecord record) {
        ApprovalRecord existingRecord = getRecordById(recordId);
        existingRecord.setApprovalResult(record.getApprovalResult());
        existingRecord.setApprovalOpinion(record.getApprovalOpinion());
        return approvalRecordRepository.save(existingRecord);
    }

    @Override
    public void deleteRecord(Long recordId) {
        approvalRecordRepository.deleteById(recordId);
    }
}