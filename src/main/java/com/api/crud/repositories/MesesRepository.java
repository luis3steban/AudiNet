package com.api.crud.repositories;

import com.api.crud.models.Meses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MesesRepository extends JpaRepository<Meses, Long> {
    Optional<Meses> findByGestionAndMes(Integer gestion, String mes);

    // Métodos personalizados, si es necesario
}
