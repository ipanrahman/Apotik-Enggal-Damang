/*
 * Copyright (c) Ipan Taupik Rahman
 */

package com.github.ipan97.enggal.damang.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by ipan on 03/06/17.
 */
@Entity
public class Employee extends AbstractModel<Long> {

    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "gender", length = 15)
    private String gender;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;
    @Column(name = "email", length = 25)
    private String email;
    @Column(name = "status", length = 20)
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
