package com.workflow.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class SysPermission implements Serializable {
    private Long id;
    private String permissionName;
    private String permissionCode;
    private Integer type;
    private Long parentId;
    private Integer sort;
    private Date createTime;
} 