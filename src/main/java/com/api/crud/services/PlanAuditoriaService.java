package com.api.crud.services;



import com.api.crud.models.PlanAuditoria;
import com.api.crud.repositories.PlanAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanAuditoriaService {

    @Autowired
    private PlanAuditoriaRepository repository;

    public List<PlanAuditoria> getAll() {
        return repository.planaudiDatos();
    }

    public PlanAuditoria getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public PlanAuditoria save(PlanAuditoria planAuditoria) {
        return repository.save(planAuditoria);
    }


    public void delete(int id) {
        repository.deleteById(id);
    }
}
