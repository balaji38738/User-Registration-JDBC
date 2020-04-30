package com.bridgelabz.model;

import com.bridgelabz.LoginCredentials;
import com.bridgelabz.BasicDetails;
import com.bridgelabz.ContactDetails;

import java.time.LocalDate;

public class User {
    private BasicDetails basicDetails;
    private LoginCredentials loginCredentials;
    private ContactDetails contactDetails;
    private String address;
    private LocalDate registerDate;

    public User(BasicDetails basicDetails, ContactDetails contactDetails,
                LoginCredentials loginCredentials) {
        this.basicDetails = basicDetails;
        this.contactDetails = contactDetails;
        this.loginCredentials = loginCredentials;
    }

    public BasicDetails getBasicDetails() {
        return basicDetails;
    }

    public LoginCredentials getLoginCredentials() {
        return loginCredentials;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
