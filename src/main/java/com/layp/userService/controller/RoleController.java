package com.layp.userService.controller;

import com.layp.userService.entities.Role;
import com.layp.userService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired

    private RoleService roleService;
    @PostMapping("/saveRole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        Role role1=roleService.saveRole(role);
        return new ResponseEntity<>(role1, HttpStatus.CREATED);
    }
    @GetMapping("/getRole/{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") String id){
        Role role=roleService.getRoleById(id);
        return new ResponseEntity<>(role,HttpStatus.OK);
    }
}
