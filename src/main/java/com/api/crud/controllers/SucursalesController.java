package com.api.crud.controllers;

import com.api.crud.models.Sucursales;
import com.api.crud.services.SucursalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalesController {

    @Autowired
    private SucursalesServices sucursalesServices;

    @GetMapping
    public List<Sucursales> getSucursales() {
        return sucursalesServices.getSucursales();
    }

    @PostMapping
    public ResponseEntity<Sucursales> saveSucursales(@RequestBody Sucursales sucursal) {
        try {
    
            Sucursales savedSucursales = sucursalesServices.saveSucursales(sucursal);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Sucursales> updateSucursal(@PathVariable Long id, @RequestBody Sucursales sucursal) {
        try {
            Optional<Sucursales> updatedSucursalOpt = sucursalesServices.updateSucursal(id, sucursal);
            return updatedSucursalOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Long id) {
        try {
            sucursalesServices.deleteSucursal(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
