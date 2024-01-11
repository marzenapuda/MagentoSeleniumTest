package com.marzenap.models;

public class Customer {

    private String firstName = "firstName";
    private String lastName = "lastName";
    private String email = "email@email.com";

    private String password = "Password1";

    private String confirmPassword = password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConformPassword() {
        return confirmPassword;
    }

    public void setConformPassword(String conformPassword) {
        this.confirmPassword = conformPassword;
    }
}
