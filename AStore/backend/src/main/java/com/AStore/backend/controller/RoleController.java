package com.AStore.backend.controller;

import com.AStore.backend.model.Role;
import com.AStore.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Role> getRoleById(
            @PathVariable(name = "id") Long id) {
        Optional<Role> role = roleService.getRoleById(id);
        if (role.isPresent()) {
            return ResponseEntity.ok(role.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping
    public Iterable<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Role saveRole(@RequestBody Role account) {
        return roleService.saveRole(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRole(
            @PathVariable(name = "id") Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

}
