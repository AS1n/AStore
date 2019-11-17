package com.AStore.backend.service.impl;

import com.AStore.backend.model.Role;
import com.AStore.backend.repository.RoleRepository;
import com.AStore.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role saveRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        repository.deleteById(id);
    }
}
