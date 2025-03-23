package com.api.crud.controllers;

import com.api.crud.models.Meses;
import com.api.crud.repositories.MesesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/meses")
public class MesesController {

    @Autowired
    private MesesRepository mesesRepository;

    @PostMapping
    public ResponseEntity<String> createMonth(@RequestBody Meses mes) {
        // Establecer la fecha de creación
        mes.setFecha_creacion(LocalDateTime.now());

        // Guarda en la tabla `Meses`
        mesesRepository.save(mes);
        return ResponseEntity.ok("Mes guardado correctamente.");
    }

    @GetMapping
    public List<Meses> getAllMonths() {
        return mesesRepository.findAll();
    }
}
