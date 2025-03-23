package com.api.crud.controllers;

import com.api.crud.models.Informe;
import com.api.crud.services.InformeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/informes")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class InformeController {
    private static final Logger log = LoggerFactory.getLogger(InformeController.class);

    private final InformeService informeService;

    @Autowired
    public InformeController(InformeService service) {
        this.informeService = service;
    }

    @PostMapping
    public ResponseEntity<Informe> crearInforme(@RequestBody Informe informeAuditoria) {
        Informe creado = informeService.guardarInforme(informeAuditoria);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }
}