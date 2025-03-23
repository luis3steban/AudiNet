package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String actividad;

    @Column
    private String norma;

    @Column
    private String nivelRiesgo;

    @Column
    private String hechoPor;

    @Column
    private String comentarios;

    @Column
    private String criterio;

    @Column
    private String referencia;

    @Column
    private Boolean concluido;

    @Column
    private Boolean revisado;

    // Nueva relación de clave foránea con la tabla `plan_auditorias`
    @ManyToOne
    @JoinColumn(name = "plan_auditoria_id", referencedColumnName = "id")
    private PlanAuditoria planAuditoria; // Campo que almacena la relación con `PlanAuditorias`

    // Getters y setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getNorma() {
        return norma;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getHechoPor() {
        return hechoPor;
    }

    public void setHechoPor(String hechoPor) {
        this.hechoPor = hechoPor;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public Boolean getRevisado() {
        return revisado;
    }

    public void setRevisado(Boolean revisado) {
        this.revisado = revisado;
    }


    public boolean isConcluido() { // Método getter para el campo `concluido`
        return concluido;
    }

    public void setConcluido(boolean concluido) { // Método setter para el campo `concluido`
        this.concluido = concluido;
    }

    public PlanAuditoria getPlanAuditoria() {
        return planAuditoria;
    }

    public void setPlanAuditoria(PlanAuditoria planAuditoria) {
        this.planAuditoria = planAuditoria;
    }
}

