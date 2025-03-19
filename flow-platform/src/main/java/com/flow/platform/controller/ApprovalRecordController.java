package com.flow.platform.controller;

import com.flow.platform.service.ApprovalRecordService;
import com.flow.platform.entity.ApprovalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approval-records")
public class ApprovalRecordController {

    @Autowired
    private ApprovalRecordService approvalRecordService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ApprovalRecord>> getAllRecords() {
        return ResponseEntity.ok(approvalRecordService.getAllRecords());
    }

    @GetMapping("/{recordId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApprovalRecord> getRecordById(@PathVariable Long recordId) {
        return ResponseEntity.ok(approvalRecordService.getRecordById(recordId));
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApprovalRecord> createRecord(@RequestBody ApprovalRecord record) {
        return ResponseEntity.ok(approvalRecordService.createRecord(record));
    }

    @PutMapping("/{recordId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApprovalRecord> updateRecord(@PathVariable Long recordId, @RequestBody ApprovalRecord record) {
        return ResponseEntity.ok(approvalRecordService.updateRecord(recordId, record));
    }

    @DeleteMapping("/{recordId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
        approvalRecordService.deleteRecord(recordId);
        return ResponseEntity.noContent().build();
    }
}