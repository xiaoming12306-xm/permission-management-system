package com.flow.platform.utils;

import com.flow.platform.exception.ValidationException;

public class ValidationUtils {

    /**
     * 验证对象是否为空
     */
    public static void validateNotNull(Object obj, String message) {
        if (obj == null) {
            throw new ValidationException(message);
        }
    }

    /**
     * 验证字符串是否为空
     */
    public static void validateNotEmpty(String str, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new ValidationException(message);
        }
    }
}