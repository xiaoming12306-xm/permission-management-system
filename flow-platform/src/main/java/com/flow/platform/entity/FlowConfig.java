package com.flow.platform.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
public class FlowConfig {
    private List<FlowNode> nodes; // 流程节点列表
}

@Data
class FlowNode {
    private String nodeName;     // 节点名称
    private List<Long> approvers; // 审批人列表
}