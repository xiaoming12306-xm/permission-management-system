package com.flow.platform.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Permission {
    private Long permId;      // 权限ID
    private String permName;  // 权限名称
    private String permKey;   // 权限标识
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermKey() {
        return permKey;
    }

    public void setPermKey(String permKey) {
        this.permKey = permKey;
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