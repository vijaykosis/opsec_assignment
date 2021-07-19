package com.opsec.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleApiException(UserNotFoundException ex) {
        ErrorResponse response =
                new ErrorResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getHttpStatus().toString(), ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}