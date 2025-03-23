package com.api.crud.controllers;

import com.api.crud.models.Auditoria;
import com.api.crud.repositories.AuditoriaRepository;
import com.api.crud.services.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})  // Ajusta el origen según tu frontend

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaRepository auditoriaRepository;
    @Autowired
    private AuditoriaService auditoriaService; // Asegúrate de tener un servicio que maneje la lógica de negocio

    // Método para guardar una auditoría
    @PostMapping("/guardarRegistro")
    public ResponseEntity<Auditoria> createAuditoria(@RequestBody Auditoria auditoria) {
        Auditoria savedAuditoria = auditoriaRepository.save(auditoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuditoria);
    }
    @PostMapping("/guardarRegistros")
    public ResponseEntity<List<Auditoria>> guardarAuditorias(@RequestBody List<Auditoria> auditorias) {
        List<Auditoria> savedAuditorias = auditoriaRepository.saveAll(auditorias);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuditorias);
    }


    // Método para obtener una auditoría por ID
    // Método para verificar si un registro existe por su ID
    @GetMapping("/verificarRegistro/{id}")
    public ResponseEntity<Boolean> verificarRegistro(@PathVariable Long id) {
        boolean exists = auditoriaRepository.existsById(id);
        return ResponseEntity.ok(exists);
    }

    // Método para obtener una auditoría por ID
    @GetMapping
    public List<Auditoria> getAllAuditorias() {
        return auditoriaService.getAllAuditorias(); // Lógica para obtener todas las auditorías desde la base de datos
    }

    // Método para obtener todas las auditorías relacionadas a un planAuditoriaId
    @GetMapping("/planAuditoria/{planAuditoriaId}")
    public ResponseEntity<List<Auditoria>> getAuditoriasByPlanAuditoriaId(@PathVariable Long planAuditoriaId) {
        List<Auditoria> auditorias = auditoriaRepository.findByPlanAuditoriaId(planAuditoriaId);
        return ResponseEntity.ok(auditorias);
    }

    // Método para actualizar una auditoría existente
    @PutMapping("/actualizarRegistro/{id}")
    public ResponseEntity<Auditoria> updateAuditoria(@PathVariable Long id, @RequestBody Auditoria auditoriaDetails) {
        Optional<Auditoria> auditoriaOptional = auditoriaRepository.findById(id);
        if (!auditoriaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Auditoria auditoriaToUpdate = auditoriaOptional.get();
        // Actualiza los campos necesarios
        auditoriaToUpdate.setActividad(auditoriaDetails.getActividad());
        auditoriaToUpdate.setNorma(auditoriaDetails.getNorma());
        auditoriaToUpdate.setNivelRiesgo(auditoriaDetails.getNivelRiesgo());
        auditoriaToUpdate.setHechoPor(auditoriaDetails.getHechoPor());
        auditoriaToUpdate.setComentarios(auditoriaDetails.getComentarios());
        auditoriaToUpdate.setCriterio(auditoriaDetails.getCriterio());
        auditoriaToUpdate.setReferencia(auditoriaDetails.getReferencia());
        auditoriaToUpdate.setConcluido(auditoriaDetails.isConcluido());
        auditoriaToUpdate.setRevisado(auditoriaDetails.getRevisado());

        Auditoria updatedAuditoria = auditoriaRepository.save(auditoriaToUpdate);
        return ResponseEntity.ok(updatedAuditoria);
    }

    // Método para eliminar una auditoría por ID
    @DeleteMapping("/eliminarFila/{id}")
    public ResponseEntity<Void> deleteAuditoria(@PathVariable Long id) {
        Optional<Auditoria> auditoriaOptional = auditoriaRepository.findById(id);
        if (auditoriaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        auditoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
