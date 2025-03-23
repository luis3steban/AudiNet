package com.api.crud.controllers;

import com.api.crud.models.Crediticio;
import com.api.crud.models.Operativo;
import com.api.crud.services.OperativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/operativos")
@CrossOrigin(origins = "http://localhost:3000") // Ajusta la URL de tu frontend
public class OperativoController {
    @Autowired
    private OperativoService operativoService;

    @PostMapping("/bulk")
    public ResponseEntity<String> createBulk(@RequestBody Operativo operativo) {
        Operativo creado = operativoService.create(operativo);
        if (creado == null) {
            return new ResponseEntity<>("Error al crear el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
        return new ResponseEntity<>("Registro creado exitosamente.", HttpStatus.CREATED);
    }
    @GetMapping("/{codigo}")
    public Optional<Operativo> read(@PathVariable Long codigo) {
        return operativoService.read(codigo);
    }

    @GetMapping
    public List<Operativo> readAll() {
        return operativoService.findAll();
    }

    @PutMapping("/{codigo}")
    public  Operativo update(@PathVariable Long codigo, @RequestBody Operativo operativo) {
        return operativoService.update(codigo, operativo);
    }

    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        operativoService.delete(codigo);
    }
}


