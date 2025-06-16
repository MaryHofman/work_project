package com.example.security.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.security.application.dto.out.ErrorResponseDto;
import com.example.security.infrastructure.exception.ApiException;
import com.example.security.infrastructure.exception.ErrorCode;

import java.util.Locale;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponseDto> handleApiException(ApiException ex, Locale locale) {
        String localizedMessage = messageSource.getMessage(ex.getMessage(), ex.getArgs(), ex.getMessage(), locale);
        ErrorResponseDto error = new ErrorResponseDto(localizedMessage, ex.getErrorCode().name());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGeneralException(Exception ex, Locale locale) {
        String localizedMessage = messageSource.getMessage("INTERNAL_SERVER_ERROR", null, "Internal server error", locale);
        ErrorResponseDto error = new ErrorResponseDto(localizedMessage, ErrorCode.INTERNAL_SERVER_ERROR.name());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}