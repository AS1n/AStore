package com.AStore.backend.service;

import com.AStore.backend.model.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    Page<User> getAllUsers(Integer page, Integer size);
    User changeRole(User user, Long roleId);
    void deleteUser(Long id);
}
