package com.api.crud.repositories;


import com.api.crud.models.Informe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeRepository extends JpaRepository<Informe, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}
