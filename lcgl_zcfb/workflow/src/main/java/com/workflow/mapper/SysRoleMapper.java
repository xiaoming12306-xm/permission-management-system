package com.workflow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workflow.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    
    /**
     * 根据用户ID查询角色列表
     */
    List<SysRole> selectRolesByUserId(@Param("userId") Long userId);
    
    /**
     * 根据角色ID查询角色信息
     */
    SysRole selectRoleById(@Param("roleId") Long roleId);
    
    /**
     * 根据角色编码查询角色信息
     */
    SysRole selectRoleByCode(@Param("roleCode") String roleCode);
} 