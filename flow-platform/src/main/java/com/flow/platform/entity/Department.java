package com.flow.platform.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Data
public class Department {
    private Long deptId;      // 部门ID
    private String deptName;  // 部门名称
    private Long parentId;    // 父部门ID
    private Integer orderNum; // 显示顺序
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

}