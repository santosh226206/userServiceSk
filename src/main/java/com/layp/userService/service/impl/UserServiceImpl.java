package com.layp.userService.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.userService.domain.Hotel;
import com.layp.userService.domain.Rating;
import com.layp.userService.entities.User;
import com.layp.userService.exception.ResourceNotFoundException;
import com.layp.userService.repository.UseRepository;
import com.layp.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UseRepository useRepository;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String uuid= UUID.randomUUID().toString();
        user.setId(uuid);
        return useRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
             User user=   useRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Does Not Esixt"));
             Rating[] ratingsArray = restTemplate.getForObject("http://RATING-SERVICE/api/ratings/rating/user/" + id, Rating[].class);
             List<Rating> ratings = Arrays.asList(ratingsArray);
        ratings = ratings.stream().map((item) -> {
            Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/api/hotels/getHotel/" + item.getHotelId(), Hotel.class);
            item.setHotel(hotel);
            return item;
        }).collect(Collectors.toList());

        user.setRatings(ratings);
             return user;
    }

    @Override
    public List<User> getAllUser() {
        return useRepository.findAll();
    }

    @Override
    public User updateUser(String id, JsonNode userUpdates) {
        User existingUser = useRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Check and update fields based on the request body (JsonNode)
        if (userUpdates.has("username") && !userUpdates.get("username").isNull()) {
            existingUser.setUsername(userUpdates.get("username").asText());
        }

        if (userUpdates.has("email") && !userUpdates.get("email").isNull()) {
            existingUser.setEmail(userUpdates.get("email").asText());
        }
        if (userUpdates.has("password") && !userUpdates.get("password").isNull()) {
            existingUser.setPassword(userUpdates.get("password").asText());
        }
        if (userUpdates.has("role") && !userUpdates.get("role").isNull()) {
            existingUser.setRole(userUpdates.get("role").asText());
        }

        // Save the updated entity (this performs the update)
        return useRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String userId) {
        useRepository.deleteById(userId);
    }
}
