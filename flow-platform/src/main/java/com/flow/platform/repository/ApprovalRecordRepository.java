package com.flow.platform.repository;

import com.flow.platform.entity.ApprovalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 审批记录仓库接口
 */
@Repository
public interface ApprovalRecordRepository extends JpaRepository<ApprovalRecord, Long> {

    /**
     * 根据表单ID查找审批记录
     *
     * @param formId 表单ID
     * @return 审批记录列表
     */
    List<ApprovalRecord> findByFormId(Long formId);

    /**
     * 根据审批人ID查找审批记录
     *
     * @param approver 审批人ID
     * @return 审批记录列表
     */
    List<ApprovalRecord> findByApprover(Long approver);

    /**
     * 根据审批结果查找审批记录
     *
     * @param approvalResult 审批结果（0:拒绝, 1:通过）
     * @return 审批记录列表
     */
    List<ApprovalRecord> findByApprovalResult(Integer approvalResult);

    /**
     * 根据记录ID查找审批记录
     *
     * @param recordId 记录ID
     * @return 审批记录
     */
    ApprovalRecord findByRecordId(Long recordId);

    /**
     * 根据记录ID删除审批记录
     *
     * @param recordId 记录ID
     */
    void deleteByRecordId(Long recordId);
}