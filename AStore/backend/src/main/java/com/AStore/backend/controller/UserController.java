package com.AStore.backend.controller;

import com.AStore.backend.model.User;
import com.AStore.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable(name = "id") Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping
    public Iterable<User> getAllUsers(
            @RequestParam(name = "page") Integer pageNumber,
            @RequestParam(name = "size") Integer size) {
        Page page = userService.getAllUsers(pageNumber, size);
        return page.getContent();
    }

    @RequestMapping(value = "/total-pages")
    public Integer getTotalPages(
            @RequestParam(name = "size") Integer size) {
        Page page = userService.getAllUsers(1, size);
        return page.getTotalPages();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(
            @RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/change-role", method = RequestMethod.POST)
    public User changeRole(
            @RequestBody User user,
            @RequestParam(name = "new") Long newRole
    ) {
        return userService.changeRole(user, newRole);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(
            @PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/u/{username}")
    public ResponseEntity<User> getUserByUsername(
            @PathVariable(name = "username") String username) {
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
