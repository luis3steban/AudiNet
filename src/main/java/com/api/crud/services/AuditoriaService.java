package com.api.crud.services;

import com.api.crud.models.Auditoria;
import com.api.crud.repositories.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public List<Auditoria> getAllAuditorias() {
        return auditoriaRepository.findAll();
    }

    public void saveAuditorias(List<Auditoria> auditorias) {
        auditoriaRepository.saveAll(auditorias);
    }

    public void updateAuditoria(Long id, Auditoria updatedAuditoria) {
        Auditoria auditoria = auditoriaRepository.findById(id).orElseThrow();
        auditoria.setActividad(updatedAuditoria.getActividad());
        auditoria.setNorma(updatedAuditoria.getNorma());
        auditoria.setNivelRiesgo(updatedAuditoria.getNivelRiesgo());
        auditoria.setHechoPor(updatedAuditoria.getHechoPor());
        auditoria.setComentarios(updatedAuditoria.getComentarios());
        auditoria.setCriterio(updatedAuditoria.getCriterio());
        auditoria.setReferencia(updatedAuditoria.getReferencia());
        auditoria.setConcluido(updatedAuditoria.isConcluido());
        auditoria.setRevisado(updatedAuditoria.getRevisado());
        auditoriaRepository.save(auditoria);
    }

    public void deleteAuditoria(Long id) {
        auditoriaRepository.deleteById(id);
    }
}

