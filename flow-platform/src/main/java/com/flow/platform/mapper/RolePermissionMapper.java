package com.flow.platform.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RolePermissionMapper {

    @Insert("INSERT INTO sys_role_permission (role_id, perm_id) VALUES (#{roleId}, #{permId})")
    void insertRolePermission(Long roleId, Long permId);

    @Delete("DELETE FROM sys_role_permission WHERE role_id = #{roleId} AND perm_id = #{permId}")
    void deleteRolePermission(Long roleId, Long permId);

    @Select("SELECT perm_id FROM sys_role_permission WHERE role_id = #{roleId}")
    List<Long> findPermIdsByRoleId(Long roleId);
}