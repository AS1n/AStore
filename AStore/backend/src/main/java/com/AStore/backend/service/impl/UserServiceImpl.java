package com.AStore.backend.service.impl;

import com.AStore.backend.model.User;
import com.AStore.backend.repository.UserRepository;
import com.AStore.backend.service.RoleService;
import com.AStore.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleService roleService) {
        this.repository = repository;
        this.roleService = roleService;
    }

    @Override
    public User saveUser(User user) {
        boolean temp = repository.findByUsername(user.getUsername()).isPresent();
        if (user.getId() != null || !temp)
            return repository.save(user);
        else return null;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Page<User> getAllUsers(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page - 1, size, new Sort(Sort.Direction.ASC, "id"));
        return repository.findAll(pageable);
    }

    @Override
    public User changeRole(User user, Long roleId) {
        boolean temp = repository.findByUsername(user.getUsername()).isPresent();
        if (user.getId() != null || !temp) {
            user.setRole(roleService.getRoleById(roleId).get());
            return repository.save(user);
        } else return null;
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
