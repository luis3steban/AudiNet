package com.api.crud.models;

public class LoginResponse {
    private String rol;

    public LoginResponse(String rol) {
        this.rol = rol;
    }

    // Getters y Setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

