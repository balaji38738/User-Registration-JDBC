package com.bridgelabz.model;

public class BasicDetails {
    private String firstName;
    private String lastName;

    public BasicDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
