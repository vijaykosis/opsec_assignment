package com.opsec.api.error;

public class UserNotFoundException extends RuntimeException {

    private ErrorCode code;

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public UserNotFoundException(ErrorCode code) {
        this.code = code;
    }

    public UserNotFoundException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public UserNotFoundException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }
}