package com.example.demodoan.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}
