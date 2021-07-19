package com.opsec.api.model;

import com.opsec.api.error.ErrorResponse;

public class ApiStatus {


    private boolean success;
    private ErrorResponse response;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorResponse getResponse() {
        return response;
    }

    public void setResponse(ErrorResponse response) {
        this.response = response;
    }
}
