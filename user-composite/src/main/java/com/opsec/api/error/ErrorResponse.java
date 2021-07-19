package com.opsec.api.error;

public class ErrorResponse extends RuntimeException {
    String code;
    String message;
    Exception causeBy;


    public String getCode() {
        return code;
    }

    public ErrorResponse(String message, String code,Exception causeBy) {
        super(message);
        this.code = code;
        this.message=message;
        this.causeBy = causeBy;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getCauseBy() {
        return causeBy;
    }

    public void setCauseBy(Exception causeBy) {
        this.causeBy = causeBy;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", causeBy=" + causeBy +
                '}';
    }
}