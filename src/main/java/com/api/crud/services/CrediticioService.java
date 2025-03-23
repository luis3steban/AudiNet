package com.api.crud.services;


import com.api.crud.models.Crediticio;
import com.api.crud.repositories.CrediticioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrediticioService {
    @Autowired
    private CrediticioRepository crediticioRepository;

    public Crediticio create(Crediticio crediticio) {
        return crediticioRepository.save(crediticio);
    }
    public Optional<Crediticio> read(Long codigo) {
        return crediticioRepository.findById(codigo);
    }
    public List<Crediticio> findAll() {
        return crediticioRepository.findAll();
    }

    public Crediticio update(Long codigo, Crediticio crediticio) {
        if (crediticioRepository.existsById(codigo))
            crediticio.setCodigo(codigo);  
            return crediticioRepository.save(crediticio);

    }

    public void delete(Long codigo) {
        crediticioRepository.deleteById(codigo);
    }
}


