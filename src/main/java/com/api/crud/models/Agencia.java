package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name="agencias")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  agencia; // Campo para el nombre del departamento

    private Long sucursal_id; // Campo para el nombre del departamento

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Long getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(Long sucursal_id) {
        this.sucursal_id = sucursal_id;
    }
}
