package com.api.crud.models;



import jakarta.persistence.*;



@Entity
@Table(name = "plan_auditorias")
public class PlanAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Este campo es el Nro.

    @Column(nullable = false)
    private String auditoria; // Nombre de la auditoría

    @Column(nullable = false)
    private String mes; // Mes

    private String nac_suc_age; // Nacional / Sucursal / Agencia

    private String sucursal; // Nombre de la sucursal

    private String responsable;
    private String equipo_trabajo;
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getNacSucAge() {
        return nac_suc_age;
    }

    public void setNacSucAge(String nac_suc_age) {
        this.nac_suc_age = nac_suc_age;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEquipoTrabajo() {
        return equipo_trabajo;
    }

    public void setEquipoTrabajo(String equipo_trabajo) {
        this.equipo_trabajo = equipo_trabajo;
    }
}

