package com.layp.userService.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.userService.domain.AuthRequest;
import com.layp.userService.entities.User;
import com.layp.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/saveUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get a user by ID
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Get all users
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Update user details
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody JsonNode userUpdates) {
        User updatedUser = userService.updateUser(id, userUpdates);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Delete a user by ID
    @DeleteMapping("/removeUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }
    @PostMapping("/validate")
    public ResponseEntity<Optional<User>> validateUser(@RequestBody AuthRequest request) {
        // Validate credentials and return user details with role
        Optional<User> user=userService.getByUserNameAndId(request.getUsername(),request.getPassword());
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
