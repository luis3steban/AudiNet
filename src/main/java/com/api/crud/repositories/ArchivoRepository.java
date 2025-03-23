package com.api.crud.repositories;
import com.api.crud.models.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Long> {
    List<Archivo> findByFilaId(Long filaId); // Definir el método para obtener archivos por filaId

}
