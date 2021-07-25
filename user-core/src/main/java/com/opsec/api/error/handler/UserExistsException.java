package com.opsec.api.error.handler;

public class UserExistsException extends Exception {

    private static final long serialVersionUID = -7806029002430564887L;

    private String message;
    private int code;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UserExistsException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public UserExistsException(String message, String message1, int code) {
        super(message);
        this.message = message1;
        this.code = code;
    }

    public UserExistsException(String message, Throwable cause, String message1, int code) {
        super(message, cause);
        this.message = message1;
        this.code = code;
    }

    public UserExistsException(Throwable cause, String message, int code) {
        super(cause);
        this.message = message;
        this.code = code;
    }

    public UserExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserExistsException{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
