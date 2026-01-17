package com.layp.userService.repository;

import com.layp.userService.entities.Role;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,String> {
    @Query(value = "SELECT *FROM roles WHERE name =:roleName",nativeQuery = true)
    List<Role> findeRoleByName(@Param("roleName") String roleName);
}
