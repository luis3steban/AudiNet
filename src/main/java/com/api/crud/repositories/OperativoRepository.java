package com.api.crud.repositories;
import com.api.crud.models.Operativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperativoRepository extends JpaRepository<Operativo, Long> {
}
