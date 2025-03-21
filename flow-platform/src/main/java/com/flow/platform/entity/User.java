package com.flow.platform.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Data
@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;       // 用户ID

    private String username;  // 用户名
    private String password;  // 密码
    private Long deptId;      // 部门ID
    private String email;     // 邮箱
    private String wxUserid;  // 企业微信用户ID
    private Integer status;   // 状态（0:禁用, 1:正常）
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

    // 用户与角色的多对多关联
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}