package com.layp.userService.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.userService.domain.UserUpdateDto;
import com.layp.userService.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    public User updateUser(String id, UserUpdateDto user);
    // TODO: delete user
    public void deleteUser(String userId);
    public Optional<User> getByUserNameAndId(String username, String password);
//    @Query(value = "SELECT * FROM users WHERE email_id = :emailId", nativeQuery = true)
//    public User getUserByEmailId(@Param("emailId") String emailId);
}
