package com.api.crud.repositories;

import com.api.crud.models.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByPlanAuditoriaId(Long planAuditoriaId);

}




