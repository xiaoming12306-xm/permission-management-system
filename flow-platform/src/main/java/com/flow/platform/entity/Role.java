package com.flow.platform.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Role {
    private Long roleId;      // 角色ID
    private String roleName;  // 角色名称
    private String roleKey;   // 角色权限字符
    private Integer dataScope; // 数据范围（1:全部, 2:自定义）
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getDataScope() {
        return dataScope;
    }

    public void setDataScope(Integer dataScope) {
        this.dataScope = dataScope;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}