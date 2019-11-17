package com.AStore.backend.service;

import com.AStore.backend.model.Role;

import java.util.Optional;

public interface RoleService {
    Role saveRole(Role category);
    Optional<Role> getRoleById(Long id);
    Iterable<Role> getAllRoles();
    void deleteRole(Long id);
}
