package com.workflow.exception;

public class NoLoginException extends RuntimeException {
    
    public NoLoginException(String message) {
        super(message);
    }
    
    public NoLoginException(String message, Throwable cause) {
        super(message, cause);
    }
} 