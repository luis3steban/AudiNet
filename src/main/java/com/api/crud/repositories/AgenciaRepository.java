package com.api.crud.repositories;

import com.api.crud.models.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}

