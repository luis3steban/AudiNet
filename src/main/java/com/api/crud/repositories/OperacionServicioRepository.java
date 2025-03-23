package com.api.crud.repositories;

import com.api.crud.models.OperacionYServicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacionServicioRepository extends JpaRepository<OperacionYServicio, Long> {
}
