package com.example.exercise.entities.user;

import com.example.exercise.exceptions.ValidationException;

public class RegisterDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public RegisterDTO(String[] commandParts){

        this.email = commandParts[1];
        this.password = commandParts[2];
        this.confirmPassword = commandParts[3];
        this.fullName = commandParts[4];

        this.validate();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    private void validate() {

        int indexOfAt = email.indexOf("@");
        int indexOfDot = email.lastIndexOf(".");
        if (indexOfAt < 0 || indexOfDot < 0 || indexOfAt > indexOfDot){
            throw new ValidationException("Incorrect email. Email must contain @ and .");
        }

        //TODO validate password

        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Password and confirm password should match!");
        }


    }
}
