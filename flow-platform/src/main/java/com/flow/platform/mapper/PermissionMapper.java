package com.flow.platform.mapper;

import com.flow.platform.entity.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("SELECT * FROM sys_permission")
    List<Permission> findAll();

    @Select("SELECT * FROM sys_permission WHERE perm_id = #{permId}")
    Permission findById(Long permId);

    @Insert("INSERT INTO sys_permission (perm_name, perm_key) " +
            "VALUES (#{permName}, #{permKey})")
    @Options(useGeneratedKeys = true, keyProperty = "permId")
    void insert(Permission permission);

    @Update("UPDATE sys_permission SET perm_name = #{permName}, perm_key = #{permKey} " +
            "WHERE perm_id = #{permId}")
    void update(Permission permission);

    @Delete("DELETE FROM sys_permission WHERE perm_id = #{permId}")
    void deleteById(Long permId);
}