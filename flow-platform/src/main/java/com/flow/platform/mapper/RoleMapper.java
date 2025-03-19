package com.flow.platform.mapper;

import com.flow.platform.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM sys_role")
    List<Role> findAll();

    @Select("SELECT * FROM sys_role WHERE role_id = #{roleId}")
    Role findById(Long roleId);

    @Insert("INSERT INTO sys_role (role_name, role_key, data_scope) " +
            "VALUES (#{roleName}, #{roleKey}, #{dataScope})")
    @Options(useGeneratedKeys = true, keyProperty = "roleId")
    void insert(Role role);

    @Update("UPDATE sys_role SET role_name = #{roleName}, role_key = #{roleKey}, data_scope = #{dataScope} " +
            "WHERE role_id = #{roleId}")
    void update(Role role);

    @Delete("DELETE FROM sys_role WHERE role_id = #{roleId}")
    void deleteById(Long roleId);
}