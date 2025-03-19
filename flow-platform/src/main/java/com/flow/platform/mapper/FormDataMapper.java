package com.flow.platform.mapper;

import com.flow.platform.entity.FormData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FormDataMapper {

    @Select("SELECT * FROM biz_form_data")
    List<FormData> findAll();

    @Select("SELECT * FROM biz_form_data WHERE form_id = #{formId}")
    FormData findById(Long formId);

    @Insert("INSERT INTO biz_form_data (form_type, form_data, submit_user, current_status, create_time) " +
            "VALUES (#{formType}, #{formData}, #{submitUser}, #{currentStatus}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "formId")
    void insert(FormData formData);

    @Update("UPDATE biz_form_data SET form_type = #{formType}, form_data = #{formData}, current_status = #{currentStatus} " +
            "WHERE form_id = #{formId}")
    void update(FormData formData);

    @Delete("DELETE FROM biz_form_data WHERE form_id = #{formId}")
    void deleteById(Long formId);
}