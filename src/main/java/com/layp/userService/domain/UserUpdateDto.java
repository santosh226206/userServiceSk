package com.layp.userService.domain;

import com.layp.userService.entities.Role;

import java.util.List;

public class UserUpdateDto {
    private String username;
    private String email;
    private String password;
    private List<Role> roles; // List of UUIDs/IDs as strings

    // Getters and Setters

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}