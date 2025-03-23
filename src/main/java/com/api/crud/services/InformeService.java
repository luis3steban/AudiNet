package com.api.crud.services;

import com.api.crud.models.Informe;
import com.api.crud.repositories.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InformeService {

    @Autowired
    private InformeRepository informeRepository;

    // Método para guardar un nuevo informe
    public Informe guardarInforme(Informe informeAuditoria) {
        return informeRepository.save(informeAuditoria);
    }
}
