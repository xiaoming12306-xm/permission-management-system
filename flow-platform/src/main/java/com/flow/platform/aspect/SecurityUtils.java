package com.flow.platform.aspect;

import com.flow.platform.entity.Permission;
import com.flow.platform.entity.User;
import com.flow.platform.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;
import java.util.stream.Collectors;

public class SecurityUtils {

    // 在用户登录时缓存权限
    public static Set<String> getCachedPermissions(User user) {
        return user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getPermKey)
                .collect(Collectors.toSet());
    }

    /**
     * 检查当前用户是否拥有指定权限
     *
     * @param permission 权限标识（如 "form:approve"）
     * @return 是否拥有权限
     */
/*    public static boolean hasPermission(String permission) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(auth -> auth.equals(permission));
        }
        return false;
    }*/

    public static boolean hasPermission(String permission) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            return false;
        }

        Set<String> permissions = getCachedPermissions(currentUser);
        return permissions.contains(permission);
    }

    /**
     * 检查当前用户是否拥有所有指定权限
     *
     * @param permissions 权限标识列表
     * @return 是否全部拥有
     */
    public static boolean hasAllPermissions(String... permissions) {
        for (String perm : permissions) {
            if (!hasPermission(perm)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取当前登录的 User 对象
     */
    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return userDetails.getUser(); // 正确调用 getUser()
        }
        return null;
    }

    /**
     * 获取当前用户ID
     */
    public static Long getCurrentUserId() {
        User currentUser = getCurrentUser();
        return currentUser != null ? currentUser.getUserId() : null;
    }

    /**
     * 获取当前用户名
     */
    public static String getCurrentUsername() {
        User currentUser = getCurrentUser();
        return currentUser != null ? currentUser.getUsername() : null;
    }

    /**
     * 检查当前用户是否拥有指定权限
     * @param permission 权限标识（如 "form:approve"）
     * @return 是否拥有权限
     */
    public static boolean hasPermissions(String[] permission) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            return false;
        }

        // 遍历用户的所有角色，收集权限
        Set<String> userPermissions = currentUser.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getPermKey)
                .collect(Collectors.toSet());

        return userPermissions.contains(permission);
    }

}