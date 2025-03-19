package com.flow.platform.repository;

import com.flow.platform.entity.FormData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表单数据仓库接口
 */
@Repository
public interface FormDataRepository extends JpaRepository<FormData, Long> {

    /**
     * 根据表单类型查找表单数据
     *
     * @param formType 表单类型
     * @return 表单数据列表
     */
    List<FormData> findByFormType(String formType);

    /**
     * 根据提交人ID查找表单数据
     *
     * @param submitUser 提交人ID
     * @return 表单数据列表
     */
    List<FormData> findBySubmitUser(Long submitUser);

    /**
     * 根据当前状态查找表单数据
     *
     * @param currentStatus 当前状态
     * @return 表单数据列表
     */
    List<FormData> findByCurrentStatus(String currentStatus);

    /**
     * 根据表单ID查找表单数据
     *
     * @param formId 表单ID
     * @return 表单数据
     */
    FormData findByFormId(Long formId);

    /**
     * 根据表单ID删除表单数据
     *
     * @param formId 表单ID
     */
    void deleteByFormId(Long formId);
}