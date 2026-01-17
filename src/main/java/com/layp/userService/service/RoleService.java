package com.layp.userService.service;

import com.layp.userService.entities.Role;

import java.util.List;

public interface RoleService {
    public Role saveRole(Role role);
    public Role getRoleById(String id);
    public void deleteRole(String id);
    public Role updateRole(Role role);
    public List<Role> getAllRole();
}
