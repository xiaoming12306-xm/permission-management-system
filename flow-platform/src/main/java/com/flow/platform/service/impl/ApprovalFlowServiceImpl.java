package com.flow.platform.service.impl;

import com.flow.platform.repository.ApprovalFlowRepository;
import com.flow.platform.service.ApprovalFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flow.platform.entity.ApprovalFlow;
import java.util.List;

@Service
public class ApprovalFlowServiceImpl implements ApprovalFlowService {

    @Autowired
    private ApprovalFlowRepository approvalFlowRepository;

    @Override
    public List<ApprovalFlow> getAllFlows() {
        return approvalFlowRepository.findAll();
    }

    @Override
    public ApprovalFlow getFlowById(Long flowId) {
        return approvalFlowRepository.findById(flowId)
            .orElseThrow(() -> new RuntimeException("审批流程未找到"));
    }

    @Override
    public ApprovalFlow createFlow(ApprovalFlow flow) {
        return approvalFlowRepository.save(flow);
    }

    @Override
    public ApprovalFlow updateFlow(Long flowId, ApprovalFlow flow) {
        ApprovalFlow existingFlow = getFlowById(flowId);
        existingFlow.setFlowName(flow.getFlowName());
        existingFlow.setConfigJson(flow.getConfigJson());
        return approvalFlowRepository.save(existingFlow);
    }

    @Override
    public void deleteFlow(Long flowId) {
        approvalFlowRepository.deleteById(flowId);
    }
}