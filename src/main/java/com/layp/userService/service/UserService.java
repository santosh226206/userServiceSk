package com.layp.userService.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.userService.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // save user
    public User saveUser(User user);
    // get user from id
    public User getUserById(String id);
    // get all user
    public List<User> getAllUser();
    // TODO: update user
    public User updateUser(String id, JsonNode user);
    // TODO: delete user
    public void deleteUser(String userId);
    public Optional<User> getByUserNameAndId(String username, String password);

}
