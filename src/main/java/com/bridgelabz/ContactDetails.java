package com.bridgelabz;

public class ContactDetails {
    private String mobileNumber;
    private String email;

    public ContactDetails(String mobileNumber, String email) {
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}
