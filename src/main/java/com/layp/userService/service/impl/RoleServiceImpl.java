package com.layp.userService.service.impl;

import com.layp.userService.entities.Role;
import com.layp.userService.exception.ResourceExist;
import com.layp.userService.exception.ResourceNotFoundException;
import com.layp.userService.repository.RoleRepository;
import com.layp.userService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) throws ResourceExist {
        List<Role> roles=findeRoleByName(role.getName());
        if(roles.size()>0){
            throw new ResourceExist("Role already exists");
        }

        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Role not found"));
    }

    @Override
    public void deleteRole(String id) {
             roleRepository.deleteById(id);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
    List<Role> findeRoleByName(String name){
        return roleRepository.findeRoleByName(name);
    }
}
