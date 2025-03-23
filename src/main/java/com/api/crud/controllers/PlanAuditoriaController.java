package com.api.crud.controllers;



import com.api.crud.models.PlanAuditoria;
import com.api.crud.services.PlanAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})  // Ajusta el origen según tu frontend


@RestController
@RequestMapping("/api/plan_auditorias")
public class PlanAuditoriaController {

    @Autowired
    private PlanAuditoriaService service;

    @GetMapping("/get")
    public List<PlanAuditoria> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanAuditoria> getById(@PathVariable int id) {
        PlanAuditoria planAuditoria = service.getById(id);
        
        return planAuditoria != null ? ResponseEntity.ok(planAuditoria) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public PlanAuditoria create(@RequestBody PlanAuditoria planAuditoria) {
        return service.save(planAuditoria);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<PlanAuditoria> update(@PathVariable int id, @RequestBody PlanAuditoria planAuditoria) {
        PlanAuditoria existingPlan = service.getById(id);
        if (existingPlan != null) {
            planAuditoria.setId(id);
            return ResponseEntity.ok(service.save(planAuditoria));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

