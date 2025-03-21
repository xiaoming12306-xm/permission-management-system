package com.flow.platform.entity;

import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;      // 角色ID

    private String roleName;  // 角色名称
    private String roleKey;   // 角色权限字符
    private Integer dataScope; // 数据范围（1:全部, 2:自定义）
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "perm_id")
    )
    private List<Permission> permissions;
}