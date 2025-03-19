package com.flow.platform.mapper;

import com.flow.platform.entity.ApprovalFlow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApprovalFlowMapper {

    @Select("SELECT * FROM biz_approval_flow")
    List<ApprovalFlow> findAll();

    @Select("SELECT * FROM biz_approval_flow WHERE flow_id = #{flowId}")
    ApprovalFlow findById(Long flowId);

    @Insert("INSERT INTO biz_approval_flow (form_type, flow_name, config_json) " +
            "VALUES (#{formType}, #{flowName}, #{configJson})")
    @Options(useGeneratedKeys = true, keyProperty = "flowId")
    void insert(ApprovalFlow flow);

    @Update("UPDATE biz_approval_flow SET form_type = #{formType}, flow_name = #{flowName}, config_json = #{configJson} " +
            "WHERE flow_id = #{flowId}")
    void update(ApprovalFlow flow);

    @Delete("DELETE FROM biz_approval_flow WHERE flow_id = #{flowId}")
    void deleteById(Long flowId);
}