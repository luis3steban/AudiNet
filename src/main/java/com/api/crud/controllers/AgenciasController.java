package com.api.crud.controllers;

import com.api.crud.models.Agencia;
import com.api.crud.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agencias")
public class AgenciasController {

    @Autowired
    private AgenciaService agenciaServices;

    @GetMapping
    public List<Agencia> getAgencia() {
        return agenciaServices.getAgencia();
    }

    @PostMapping
    public ResponseEntity<Agencia> saveAgencia(@RequestBody Agencia agencia) {
        try {
            System.out.println("Received sucursal: " + agencia);
            Agencia savedAgencia = agenciaServices.saveAgencia(agencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAgencia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agencia> updateAgen(@PathVariable Long id, @RequestBody Agencia agencia) {
        try {
            Optional<Agencia> updatedAgenOpt = agenciaServices.updateAgen(id, agencia);
            return updatedAgenOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgencia(@PathVariable Long id) {
        try {
            agenciaServices.deleteAgen(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

