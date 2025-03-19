package com.flow.platform.mapper;

import com.flow.platform.entity.ApprovalRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApprovalRecordMapper {

    @Select("SELECT * FROM biz_approval_record")
    List<ApprovalRecord> findAll();

    @Select("SELECT * FROM biz_approval_record WHERE record_id = #{recordId}")
    ApprovalRecord findById(Long recordId);

    @Insert("INSERT INTO biz_approval_record (form_id, approver, approval_result, approval_opinion, approval_time) " +
            "VALUES (#{formId}, #{approver}, #{approvalResult}, #{approvalOpinion}, #{approvalTime})")
    @Options(useGeneratedKeys = true, keyProperty = "recordId")
    void insert(ApprovalRecord record);

    @Update("UPDATE biz_approval_record SET approval_result = #{approvalResult}, approval_opinion = #{approvalOpinion} " +
            "WHERE record_id = #{recordId}")
    void update(ApprovalRecord record);

    @Delete("DELETE FROM biz_approval_record WHERE record_id = #{recordId}")
    void deleteById(Long recordId);
}