package com.workflow.exception;

public class NoPermissionException extends RuntimeException {
    
    public NoPermissionException(String message) {
        super(message);
    }
    
    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }
} 