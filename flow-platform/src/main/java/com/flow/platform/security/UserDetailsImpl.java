package com.flow.platform.security;

import com.flow.platform.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private final User user; // 保存 User 对象的引用
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    /**
     * 从 User 对象构建 UserDetailsImpl（包含权限）
     */
    public static UserDetailsImpl build(User user) {
        // 从角色中提取权限
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getPermKey()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(user, authorities);
    }

    /**
     * 返回 User 对象
     */
    public User getUser() {
        return user;
    }

    // 实现 UserDetails 接口的其他方法
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == 1; // 根据用户状态判断是否启用
    }
}