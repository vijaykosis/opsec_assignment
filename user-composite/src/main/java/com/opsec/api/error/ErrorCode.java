package com.opsec.api.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND),
    INVALID_HEADER("INVALID_TOKEN", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN("INVALID_TOKEN", HttpStatus.UNAUTHORIZED),
    INVALID_LOGIN_DETAILS("INVALID_LOGIN_DETAILS", HttpStatus.UNAUTHORIZED),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
    MAX_LIMIT_REACHED("MAX_LIMIT_REACHED", HttpStatus.TOO_MANY_REQUESTS),
    INVALID_REQUEST("INVALID_REQUEST", HttpStatus.BAD_REQUEST),
    RUN_ASYNC_PROCESSION("ASYNC_PROCESSING_EXCEPTION", HttpStatus.UNPROCESSABLE_ENTITY),
    SUCCESS("SUCCESS", HttpStatus.OK);

    String code;
    HttpStatus httpStatus;

    ErrorCode(String code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}