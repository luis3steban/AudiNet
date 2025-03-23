package com.api.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "operacion_y_servicio")
public class OperacionYServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "`manual`")
    private String manual;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "nombre_del_proceso")
    private String nombreDelProceso;

    @Column(name = "factor_de_riesgo_auditoria")
    private String factorDeRiesgoAuditoria;

    @Column(name = "justificacion_de_probabilidad")
    private String justificacionDeProbabilidad;

    @Column(name = "justificacion_de_impacto")
    private String justificacionDeImpacto;

    @Column(name = "muy_probable")
    private BigDecimal muyProbable;

    @Column(name = "probable")
    private BigDecimal probable;

    @Column(name = "improbable")
    private BigDecimal improbable;

    @Column(name = "resultado_Probabilidad")
    private BigDecimal resultadoProbabilidad;

    @Column(name = "altamente_critico")
    private BigDecimal altamenteCritico;

    @Column(name = "critico")
    private BigDecimal critico;

    @Column(name = "no_critico")
    private BigDecimal noCritico;

    @Column(name = "resultado_Impacto")
    private BigDecimal resultadoImpacto;

    @Column(name = "riesgo")
    private BigDecimal riesgo;

    @Column(name = "auditoria_a_realizar")
    private String auditoriaARealizar;

    @Column(name = "fechas_probables_de_inicio")
    private Date fechasProbablesDeInicio;

    @Column(name = "fechas_probables_de_presentacion_de_informe")
    private Date fechasProbablesDePresentacionDeInforme;

    @Column(name = "auditoria_programada")
    private String auditoriaProgramada;

    // Getters y Setters

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNombreDelProceso() {
        return nombreDelProceso;
    }

    public void setNombreDelProceso(String nombreDelProceso) {
        this.nombreDelProceso = nombreDelProceso;
    }

    public String getFactorDeRiesgoAuditoria() {
        return factorDeRiesgoAuditoria;
    }

    public void setFactorDeRiesgoAuditoria(String factorDeRiesgoAuditoria) {
        this.factorDeRiesgoAuditoria = factorDeRiesgoAuditoria;
    }

    public String getJustificacionDeProbabilidad() {
        return justificacionDeProbabilidad;
    }

    public void setJustificacionDeProbabilidad(String justificacionDeProbabilidad) {
        this.justificacionDeProbabilidad = justificacionDeProbabilidad;
    }

    public String getJustificacionDeImpacto() {
        return justificacionDeImpacto;
    }

    public void setJustificacionDeImpacto(String justificacionDeImpacto) {
        this.justificacionDeImpacto = justificacionDeImpacto;
    }

    public BigDecimal getMuyProbable() {
        return muyProbable;
    }

    public void setMuyProbable(BigDecimal muyProbable) {
        this.muyProbable = muyProbable;
    }

    public BigDecimal getProbable() {
        return probable;
    }

    public void setProbable(BigDecimal probable) {
        this.probable = probable;
    }

    public BigDecimal getImprobable() {
        return improbable;
    }

    public void setImprobable(BigDecimal improbable) {
        this.improbable = improbable;
    }

    public BigDecimal getResultadoProbabilidad() {
        return resultadoProbabilidad;
    }

    public void setResultadoProbabilidad(BigDecimal resultadoProbabilidad) {
        this.resultadoProbabilidad = resultadoProbabilidad;
    }

    public BigDecimal getAltamenteCritico() {
        return altamenteCritico;
    }

    public void setAltamenteCritico(BigDecimal altamenteCritico) {
        this.altamenteCritico = altamenteCritico;
    }

    public BigDecimal getCritico() {
        return critico;
    }

    public void setCritico(BigDecimal critico) {
        this.critico = critico;
    }

    public BigDecimal getNoCritico() {
        return noCritico;
    }

    public void setNoCritico(BigDecimal noCritico) {
        this.noCritico = noCritico;
    }

    public BigDecimal getResultadoImpacto() {
        return resultadoImpacto;
    }

    public void setResultadoImpacto(BigDecimal resultadoImpacto) {
        this.resultadoImpacto = resultadoImpacto;
    }

    public BigDecimal getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(BigDecimal riesgo) {
        this.riesgo = riesgo;
    }

    public String getAuditoriaARealizar() {
        return auditoriaARealizar;
    }

    public void setAuditoriaARealizar(String auditoriaARealizar) {
        this.auditoriaARealizar = auditoriaARealizar;
    }

    public Date getFechasProbablesDeInicio() {
        return fechasProbablesDeInicio;
    }

    public void setFechasProbablesDeInicio(Date fechasProbablesDeInicio) {
        this.fechasProbablesDeInicio = fechasProbablesDeInicio;
    }

    public Date getFechasProbablesDePresentacionDeInforme() {
        return fechasProbablesDePresentacionDeInforme;
    }

    public void setFechasProbablesDePresentacionDeInforme(Date fechasProbablesDePresentacionDeInforme) {
        this.fechasProbablesDePresentacionDeInforme = fechasProbablesDePresentacionDeInforme;
    }

    public String getAuditoriaProgramada() {
        return auditoriaProgramada;
    }

    public void setAuditoriaProgramada(String auditoriaProgramada) {
        this.auditoriaProgramada = auditoriaProgramada;
    }
}
