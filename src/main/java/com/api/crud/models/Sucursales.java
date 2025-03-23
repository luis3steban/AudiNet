package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name="sucursales")

public class Sucursales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departamento; // Campo para el nombre del departamento

    // Constructor vacío
    public Sucursales() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
