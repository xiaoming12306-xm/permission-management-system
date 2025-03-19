package com.flow.platform.repository;

import com.flow.platform.entity.ApprovalFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 审批流程仓库接口
 */
@Repository
public interface ApprovalFlowRepository extends JpaRepository<ApprovalFlow, Long> {

    /**
     * 根据表单类型查找审批流程
     *
     * @param formType 表单类型
     * @return 审批流程列表
     */
    List<ApprovalFlow> findByFormType(String formType);

    /**
     * 根据流程名称查找审批流程
     *
     * @param flowName 流程名称
     * @return 审批流程列表
     */
    List<ApprovalFlow> findByFlowName(String flowName);

    /**
     * 根据流程ID查找审批流程
     *
     * @param flowId 流程ID
     * @return 审批流程
     */
    ApprovalFlow findByFlowId(Long flowId);

    /**
     * 根据流程ID删除审批流程
     *
     * @param flowId 流程ID
     */
    void deleteByFlowId(Long flowId);
}