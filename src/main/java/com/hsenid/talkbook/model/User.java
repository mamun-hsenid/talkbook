package com.hsenid.talkbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public class User {

    @NotNull
    private int userId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,30}$", message = "Username is invalid. Enter a valid username")
    private String username;

    @NotBlank
    @Email(message = "Enter a valid email address")
    private String email;

    @NotNull
    @Size(max = 20, min = 5, message = "Password must be within 5 to 20 characters")
    private String password;

    public User() {
    }
    public User(int userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
