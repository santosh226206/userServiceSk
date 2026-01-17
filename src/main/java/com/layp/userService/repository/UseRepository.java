package com.layp.userService.repository;

import com.layp.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UseRepository extends JpaRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM users WHERE email = :emailId", nativeQuery = true)
    List<User> getUserByEmailId(@Param("emailId") String emailId);
}
