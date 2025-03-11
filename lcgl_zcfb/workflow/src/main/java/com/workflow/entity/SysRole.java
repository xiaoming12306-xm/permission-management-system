package com.workflow.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class SysRole implements Serializable {
    private Long id;
    private String roleName;
    private String roleCode;
    private String description;
    private Integer status;
    private Date createTime;
    private Date updateTime;
} 