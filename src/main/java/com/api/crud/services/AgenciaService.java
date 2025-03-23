package com.api.crud.services;

import com.api.crud.models.Agencia;
import com.api.crud.repositories.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public List<Agencia> getAgencia() {
        return agenciaRepository.findAll();
    }

    public Agencia saveAgencia(Agencia agen) {
        return agenciaRepository.save(agen);
    }

    public Optional<Agencia> updateAgen(Long id, Agencia agen) {
        return agenciaRepository.findById(id)
                .map(existingAgen -> {
                    existingAgen.setAgencia(agen.getAgencia());
                    return agenciaRepository.save(existingAgen);
                });
    }

    public void deleteAgen(Long id) {
        agenciaRepository.deleteById(id);
    }
}
