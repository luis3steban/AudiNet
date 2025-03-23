package com.api.crud.repositories;


import com.api.crud.models.MesesDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MesesDatosRepository extends JpaRepository<MesesDatos, Long> {
    List<MesesDatos> findByDepartamentoAndMesAndGestion(String departamento,String mes, Integer gestion);
    MesesDatos findByDepartamentoAndGestionAndMesAndAuditor(String departamento, Integer gestion, String mes, String auditor);
    @Query(value = "SELECT \n" + //
                "    m.id, \n" + //
                "    m.departamento, \n" + //
                "    m.gestion, \n" + //
                "    m.mes, \n" + //
                "    u.first_name as auditor, \n" + //
                "    m.dia_1, m.dia_2, m.dia_3, m.dia_4, m.dia_5, m.dia_6, m.dia_7, m.dia_8, \n" + //
                "    m.dia_9, m.dia_10, m.dia_11, m.dia_12, m.dia_13, m.dia_14, m.dia_15, m.dia_16, \n" + //
                "    m.dia_17, m.dia_18, m.dia_19, m.dia_20, m.dia_21, m.dia_22, m.dia_23, m.dia_24, \n" + //
                "    m.dia_25, m.dia_26, m.dia_27, m.dia_28, m.dia_29, m.dia_30, m.dia_31, \n" + //
                "    m.fecha_creacion\n" + //
                "FROM dbaud.meses_datos m\n" + //
                "JOIN dbaud.users u ON m.auditor = u.iniciales\n" + //
                "WHERE m.departamento =:departamento \n" + //
                "    AND m.mes =:mes \n" + //
                "    AND m.gestion =:gestion ;\n" + //
                "", nativeQuery = true)
    List<MesesDatos> findbyquerydepartamenteandgestion(String departamento,String mes, Integer gestion);

}


