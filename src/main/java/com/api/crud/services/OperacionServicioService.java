package com.api.crud.services;


import com.api.crud.models.OperacionYServicio;
import com.api.crud.repositories.OperacionServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OperacionServicioService {
    @Autowired
    private OperacionServicioRepository operacionServicioRepository;

    public OperacionYServicio create(OperacionYServicio operacionYServicio) {
        return operacionServicioRepository.save(operacionYServicio);
    }
    public Optional<OperacionYServicio> read(Long codigo) {
        return operacionServicioRepository.findById(codigo);
    }
    public List<OperacionYServicio> findAll() {
        return operacionServicioRepository.findAll();
    }

    public  OperacionYServicio update(Long codigo,  OperacionYServicio operacionYServicio) {
        // Verifica si el registro con el ID dado existe
        if (operacionServicioRepository.existsById(codigo))
            operacionYServicio.setCodigo(codigo);  // Asegúrate de que el ID es el correcto
        return operacionServicioRepository.save(operacionYServicio);
    }
    public void delete(Long codigo) {
        operacionServicioRepository.deleteById(codigo);
    }
}


