package com.flow.platform.mapper;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserRoleMapper {

    @Insert("INSERT INTO sys_user_role (user_id, role_id) VALUES (#{userId}, #{roleId})")
    void insertUserRole(Long userId, Long roleId);

    @Delete("DELETE FROM sys_user_role WHERE user_id = #{userId} AND role_id = #{roleId}")
    void deleteUserRole(Long userId, Long roleId);

    @Select("SELECT role_id FROM sys_user_role WHERE user_id = #{userId}")
    List<Long> findRoleIdsByUserId(Long userId);
}