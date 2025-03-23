package com.api.crud.controllers;

import com.api.crud.models.Crediticio;
import com.api.crud.services.CrediticioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crediticios")
@CrossOrigin(origins = "http://localhost:3000") // Ajusta la URL de tu frontend
public class CrediticioController {
    @Autowired
    private CrediticioService crediticioService;

    @PostMapping("/bulk")
    public ResponseEntity<String> create(@RequestBody Crediticio crediticio) {
        Crediticio creado = crediticioService.create(crediticio);
        if (creado == null) {
            return new ResponseEntity<>("Error al crear el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
        return new ResponseEntity<>("Registro creado exitosamente.", HttpStatus.CREATED);
    }

    @GetMapping("/{codigo}")
    public Optional<Crediticio> read(@PathVariable Long codigo) {
        return crediticioService.read(codigo);
    }

    @GetMapping
    public List<Crediticio> readAll() {
        return crediticioService.findAll();
    }

    @PutMapping("/{codigo}")
    public Crediticio update(@PathVariable Long codigo, @RequestBody Crediticio crediticio) {
        return crediticioService.update(codigo, crediticio);
    }

    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        crediticioService.delete(codigo);
    }
}

