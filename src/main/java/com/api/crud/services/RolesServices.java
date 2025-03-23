package com.api.crud.services;

import com.api.crud.models.Roles;
import com.api.crud.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServices {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getRoles() {
        return rolesRepository.findAll();
    }

    public Roles saveRol(Roles rol) {
        return rolesRepository.save(rol);
    }

    public Optional<Roles> updateRol(Long id, Roles rol) {
        return rolesRepository.findById(id)
                .map(existingRol -> {
                    existingRol.setRol(rol.getRol());
                    return rolesRepository.save(existingRol);
                });
    }

    public void deleteRol(Long id) {
        rolesRepository.deleteById(id);
    }
}
