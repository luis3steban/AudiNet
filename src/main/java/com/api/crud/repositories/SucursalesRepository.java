package com.api.crud.repositories;

import com.api.crud.models.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SucursalesRepository extends JpaRepository<Sucursales, Long> {
}
