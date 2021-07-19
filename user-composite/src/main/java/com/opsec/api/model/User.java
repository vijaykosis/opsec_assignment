package com.opsec.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class User {
    private String id;
    private String firstName;
    private String surName;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dob;
    private String title;

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
}
