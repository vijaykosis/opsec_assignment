package com.opsec.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opsec.api.error.ErrorResponse;

import java.util.Date;

public class UserRespone {
    private String id;
    private String firstName;
    private String surName;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dob;
    private String title;
    ApiStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ApiStatus getStatus() {
        return status;
    }

    public void setStatus(ApiStatus status) {
        this.status = status;
    }
}
