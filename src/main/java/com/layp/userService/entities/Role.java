package com.layp.userService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles") // Changed to plural for standard naming
public class Role {
    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();

    private String name;

    @ManyToMany(mappedBy = "roles") // Points to the 'roles' field in the User entity
    @JsonIgnore // Prevents infinite recursion during JSON serialization
    private List<User> users = new ArrayList<>();

    public Role() {}

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}