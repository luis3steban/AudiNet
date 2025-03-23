package com.api.crud.repositories;

import com.api.crud.models.MesesDatos;
import com.api.crud.models.PlanAuditoria;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanAuditoriaRepository extends JpaRepository<PlanAuditoria, Integer> {
    @Query(value = """
        SELECT 
            a.id, 
            a.auditoria, 
            a.mes, 
            a.nac_suc_age, 
            a.sucursal, 
            CONCAT(u.first_name, ' ', u.last_name) AS responsable, 
            a.equipo_trabajo
        FROM dbaud.plan_auditorias a
        -- Unir responsable con la tabla de usuarios
        JOIN dbaud.users u ON TRIM(UPPER(a.responsable)) = TRIM(UPPER(u.iniciales))
        -- Unir el resto de los miembros del equipo según sus iniciales en el campo equipo_trabajo
        LEFT JOIN dbaud.users u2 ON FIND_IN_SET(TRIM(UPPER(u2.iniciales)), TRIM(UPPER(a.equipo_trabajo))) > 0
        GROUP BY a.id, a.auditoria, a.mes, a.nac_suc_age, a.sucursal, u.first_name, u.last_name;

    """, nativeQuery = true)
    List<PlanAuditoria> planaudiDatos();
}