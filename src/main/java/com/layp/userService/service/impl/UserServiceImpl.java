package com.layp.userService.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.userService.domain.Hotel;
import com.layp.userService.domain.Rating;
import com.layp.userService.domain.UserUpdateDto;
import com.layp.userService.entities.Role;
import com.layp.userService.entities.User;
import com.layp.userService.exception.ResourceExist;
import com.layp.userService.exception.ResourceNotFoundException;
import com.layp.userService.repository.RoleRepository;
import com.layp.userService.repository.UseRepository;
import com.layp.userService.service.RoleService;
import com.layp.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UseRepository useRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RoleService roleService;
    @Override
    public User saveUser(User user) throws ResourceExist {
//        String uuid= UUID.randomUUID().toString();
//        user.setId(uuid);
        List<User> usrs=getUserByEmailId(user.getEmail());
        if(usrs.size()>0){
                throw new ResourceExist("user with given emailId already exist");
        }
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
        }).collect(toList());

        user.setRatings(ratings);
             return user;
    }

    @Override
    public List<User> getAllUser() {
        return useRepository.findAll();
    }

    @Override
    public User updateUser(String id, UserUpdateDto updateDto) {
        // 1. Fetch existing user
        User existingUser = useRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // 2. Map fields if they are provided
        if (updateDto.getUsername() != null) {
            existingUser.setUsername(updateDto.getUsername());
        }
        if (updateDto.getEmail() != null) {
            existingUser.setEmail(updateDto.getEmail());
        }
        if (updateDto.getPassword() != null) {
            existingUser.setPassword(updateDto.getPassword());
        }

        // 3. Handle Many-to-Many Roles
        if (updateDto.getRoles() != null) {
            List<Role> updatedRoles = new ArrayList<>(updateDto.getRoles().stream()
                    .map(role -> roleService.getRoleById(role.getId()))
                    .toList());

            existingUser.setRoles(updatedRoles);
        }

        // 4. Save
        return useRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String userId) {
        useRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getByUserNameAndId(String username, String password) {
        return useRepository.findByUsernameAndPassword(username,password);
    }
    public  List<User> getUserByEmailId(String email){
        return  useRepository.getUserByEmailId(email);
    }
}
