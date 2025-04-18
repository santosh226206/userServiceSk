package com.layp.userService.repository;

import com.layp.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UseRepository extends JpaRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
