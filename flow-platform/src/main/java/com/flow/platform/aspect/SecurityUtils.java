package com.flow.platform.aspect;

import com.flow.platform.entity.User;
import com.flow.platform.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return userDetails.getUser();
        }
        return null;
    }

    public static boolean hasPermissions(String[] permissions) {
        User user = getCurrentUser();
        if (user != null) {
            // 检查用户是否拥有指定权限
            for (String permission : permissions) {
                if (!user.getPermissions().contains(permission)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}