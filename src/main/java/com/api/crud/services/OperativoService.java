package com.api.crud.services;


import com.api.crud.models.Crediticio;
import com.api.crud.models.Operativo;
import com.api.crud.repositories.CrediticioRepository;
import com.api.crud.repositories.OperativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperativoService {
    @Autowired
    private OperativoRepository operativoRepository;

    public Operativo create(Operativo operativo) {
        return operativoRepository.save(operativo);
    }
    public Optional<Operativo> read(Long codigo) {
        return operativoRepository.findById(codigo);
    }
    public List<Operativo> findAll() {
        return operativoRepository.findAll();
    }

    public  Operativo update(Long codigo,  Operativo operativo) {
        // Verifica si el registro con el ID dado existe
        if (operativoRepository.existsById(codigo))
            operativo.setCodigo(codigo);  // Asegúrate de que el ID es el correcto
        return operativoRepository.save(operativo);
    }
    public void delete(Long codigo) {
        operativoRepository.deleteById(codigo);
    }
}


