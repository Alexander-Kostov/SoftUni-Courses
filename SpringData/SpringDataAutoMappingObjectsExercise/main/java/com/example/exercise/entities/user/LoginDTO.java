package com.example.exercise.entities.user;

public class LoginDTO {
    // TODO validate email
    private String email;

    private String password;

    public LoginDTO(String[] commandLineParts) {
        this.email = commandLineParts[1];
        this.password = commandLineParts[2];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
