package com.flow.platform.service;

import java.util.List;
import com.flow.platform.entity.ApprovalRecord;

public interface ApprovalRecordService {
    List<ApprovalRecord> getAllRecords();
    ApprovalRecord getRecordById(Long recordId);
    ApprovalRecord createRecord(ApprovalRecord record);
    ApprovalRecord updateRecord(Long recordId, ApprovalRecord record);
    void deleteRecord(Long recordId);
}