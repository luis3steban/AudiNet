package com.api.crud.controllers;

import com.api.crud.models.Roles;
import com.api.crud.services.RolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesServices rolesServices;

    @GetMapping
    public List<Roles> getRoles() {
        return rolesServices.getRoles();
    }

    @PostMapping
    public ResponseEntity<Roles> saveRol(@RequestBody Roles rol) {
        try {
            Roles savedRol = rolesServices.saveRol(rol);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRol);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRol(@PathVariable Long id, @RequestBody Roles rol) {
        try {
            Optional<Roles> updatedRolOpt = rolesServices.updateRol(id, rol);
            return updatedRolOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        try {
            rolesServices.deleteRol(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

