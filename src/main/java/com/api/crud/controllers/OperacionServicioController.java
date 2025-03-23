package com.api.crud.controllers;

import com.api.crud.models.OperacionYServicio;
import com.api.crud.models.Operativo;
import com.api.crud.services.OperacionServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/operacionServicio")
@CrossOrigin(origins = "http://localhost:3000") // Ajusta la URL de tu frontend
public class OperacionServicioController {
    @Autowired
    private OperacionServicioService operacionServicioService;

    @PostMapping("/bulk")
    public ResponseEntity<String> createBulk(@RequestBody OperacionYServicio operacionYServicios) {
        OperacionYServicio creado = operacionServicioService.create(operacionYServicios);
        if (creado == null) {
            return new ResponseEntity<>("Error al crear el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
        return new ResponseEntity<>("Registro creado exitosamente.", HttpStatus.CREATED);
    }

    @GetMapping("/{codigo}")
    public Optional<OperacionYServicio> read(@PathVariable Long codigo) {
        return operacionServicioService.read(codigo);
    }

    @GetMapping
    public List<OperacionYServicio> readAll() {
        return operacionServicioService.findAll();
    }

    @PutMapping("/{codigo}")
    public  OperacionYServicio update(@PathVariable Long codigo, @RequestBody OperacionYServicio operacionYServicio) {
        return operacionServicioService.update(codigo, operacionYServicio);
    }

    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        operacionServicioService.delete(codigo);
    }
}



