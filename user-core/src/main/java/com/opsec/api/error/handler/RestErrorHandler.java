package com.opsec.api.error.handler;

import com.opsec.api.error.SecurityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object processValidationError(EntityNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(SecurityException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(SecurityException se) {
        SecurityResponse response = new SecurityResponse(se.getMessage());
        return response;
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleUserException(UserExistsException se) {
        return se.getMessage();
    }
}