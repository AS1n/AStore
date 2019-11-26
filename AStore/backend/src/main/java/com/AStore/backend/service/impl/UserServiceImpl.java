package com.AStore.backend.service.impl;

import com.AStore.backend.model.User;
import com.AStore.backend.repository.UserRepository;
import com.AStore.backend.security.JwtTokenUtil;
import com.AStore.backend.security.Constants;
import com.AStore.backend.service.RoleService;
import com.AStore.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userDataService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bcryptEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleService roleService, BCryptPasswordEncoder bcryptEncoder, JwtTokenUtil jwtTokenUtil) {
        this.repository = repository;
        this.roleService = roleService;
        this.bcryptEncoder = bcryptEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public User saveUser(User user) {
        boolean temp = repository.findByUsername(user.getUsername()).isPresent();
        if (user.getId() != null || !temp) {
            String newPass = bcryptEncoder.encode(user.getPassword());
            user.setPassword(newPass);
            return repository.save(user);
        }
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        if(getUserByUsername(username).isPresent()) {
            user = getUserByUsername(username).get();
        } else throw new UsernameNotFoundException("Invalid username or password.");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set getAuthority(User user) {
        Set authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return authorities;
    }

    @Override
    public String getUsername(String bearerToken) {
        String login = null;
        String authToken = bearerToken.replace(Constants.TOKEN_PREFIX, "");
        try {
            login = jwtTokenUtil.getUsernameFromToken(authToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
