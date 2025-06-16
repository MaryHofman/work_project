package com.example.security.infrastructure.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ErrorCode errorCode;
    private final Object[] args;

    public ApiException(ErrorCode errorCode, String message, Object... args) {
        super(message);
        this.errorCode = errorCode;
        this.args = args;
    }

    public ApiException(ErrorCode errorCode, Object... args) {
        this(errorCode, errorCode.name(), args);
    }
}