package com.api.crud.services;

import com.api.crud.models.Sucursales;
import com.api.crud.repositories.SucursalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalesServices {

    @Autowired
    private SucursalesRepository sucursalesRepository;

    public List<Sucursales> getSucursales() {
        return sucursalesRepository.findAll();
    }

    public Sucursales saveSucursales(Sucursales sucursal) {
        return sucursalesRepository.save(sucursal);
    }

    public Optional<Sucursales> updateSucursal(Long id, Sucursales sucursal) {
        return sucursalesRepository.findById(id)
                .map(existingSucursal -> {
                    existingSucursal.setDepartamento(sucursal.getDepartamento());
                    return sucursalesRepository.save(existingSucursal);
                });
    }

    public void deleteSucursal(Long id) {
        sucursalesRepository.deleteById(id);
    }
}
