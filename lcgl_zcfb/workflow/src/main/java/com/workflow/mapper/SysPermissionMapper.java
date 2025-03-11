package com.workflow.mapper;

import com.workflow.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SysPermissionMapper {
    List<SysPermission> selectPermissionsByRoleId(@Param("roleId") Long roleId);
    
    List<SysPermission> selectPermissionsByRoleIds(@Param("roleIds") List<Long> roleIds);
    
    int insertRolePermission(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
    
    int deleteRolePermission(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 删除角色的所有权限
     */
    int deleteRolePermissions(@Param("roleId") Long roleId);

    /**
     * 批量插入角色权限
     */
    int insertRolePermissions(@Param("roleId") Long roleId, @Param("permissionIds") List<Long> permissionIds);
}