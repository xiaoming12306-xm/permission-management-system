package com.flow.platform.utils;

import com.flow.platform.exception.BusinessException;
import com.flow.platform.exception.ResourceNotFoundException;
import com.flow.platform.exception.ValidationException;

public class ExceptionUtils {

    public static void throwIfNull(Object object, String message) {
        if (object == null) {
            throw new ResourceNotFoundException(message);
        }
    }

    public static void throwIfInvalid(boolean condition, String message) {
        if (!condition) {
            throw new ValidationException(message);
        }
    }

    public static void throwIfBusinessError(boolean condition, String message) {
        if (!condition) {
            throw new BusinessException(message);
        }
    }
}