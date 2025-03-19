package com.flow.platform.service;

import java.util.List;
import com.flow.platform.entity.ApprovalFlow;

public interface ApprovalFlowService {
    List<ApprovalFlow> getAllFlows();
    ApprovalFlow getFlowById(Long flowId);
    ApprovalFlow createFlow(ApprovalFlow flow);
    ApprovalFlow updateFlow(Long flowId, ApprovalFlow flow);
    void deleteFlow(Long flowId);
}