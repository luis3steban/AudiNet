package com.api.crud.repositories;

import com.api.crud.models.Crediticio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrediticioRepository extends JpaRepository<Crediticio, Long> {
}