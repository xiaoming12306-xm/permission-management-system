package com.flow.platform.utils;

import com.flow.platform.entity.FlowConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlowUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 解析流程配置 JSON
     */
    public static FlowConfig parseFlowConfig(String configJson) {
        try {
            return objectMapper.readValue(configJson, FlowConfig.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("流程配置解析失败", e);
        }
    }

    /**
     * 生成流程配置 JSON
     */
    public static String generateFlowConfig(FlowConfig flowConfig) {
        try {
            return objectMapper.writeValueAsString(flowConfig);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("流程配置生成失败", e);
        }
    }
}