package com.flow.platform.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "sys_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permId;      // 权限ID
    private String permName;  // 权限名称
    private String permKey;   // 权限标识
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

}