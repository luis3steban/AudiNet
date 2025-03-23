package com.api.crud.models;

import jakarta.persistence.*;


@Entity
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complementoId;
    private String para;
    private String cc1;
    private String cc2;
    private String de;
    private String lugarFecha;
    private String referencia;
    private String motivo;
    private String objetivo;
    private String alcance;

    @Column(length = 1000)
    private String procedimientoTecnicas;

    @Column(length = 1000)
    private String resultadoRevision;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(length = 1000)
    private String otrasObservaciones;

    @Column(length = 1000)
    private String seguimientoDebilidades1;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String debilidades;

    @Column(length = 1000)
    private String seguimientoDebilidades2;

    @Column(length = 1000)
    private String seguimientoAnterior;

    @Column(length = 1000)
    private String conclusionesRecomendaciones;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String equiposTrabajos;

    private String fechaInicioAuditoria;
    private String fechaFinAuditoria;

    @Column(length = 1000)
    private String anexo1;

    private String anexo2;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplementoId() {
        return complementoId;
    }

    public void setComplementoId(String complementoId) {
        this.complementoId = complementoId;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getCc1() {
        return cc1;
    }

    public void setCc1(String cc1) {
        this.cc1 = cc1;
    }

    public String getCc2() {
        return cc2;
    }

    public void setCc2(String cc2) {
        this.cc2 = cc2;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getLugarFecha() {
        return lugarFecha;
    }

    public void setLugarFecha(String lugarFecha) {
        this.lugarFecha = lugarFecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getProcedimientoTecnicas() {
        return procedimientoTecnicas;
    }

    public void setProcedimientoTecnicas(String procedimientoTecnicas) {
        this.procedimientoTecnicas = procedimientoTecnicas;
    }

    public String getResultadoRevision() {
        return resultadoRevision;
    }

    public void setResultadoRevision(String resultadoRevision) {
        this.resultadoRevision = resultadoRevision;
    }

    public String getOtrasObservaciones() {
        return otrasObservaciones;
    }

    public void setOtrasObservaciones(String otrasObservaciones) {
        this.otrasObservaciones = otrasObservaciones;
    }

    public String getSeguimientoDebilidades1() {
        return seguimientoDebilidades1;
    }

    public void setSeguimientoDebilidades1(String seguimientoDebilidades1) {
        this.seguimientoDebilidades1 = seguimientoDebilidades1;
    }

    public String getSeguimientoDebilidades2() {
        return seguimientoDebilidades2;
    }

    public void setSeguimientoDebilidades2(String seguimientoDebilidades2) {
        this.seguimientoDebilidades2 = seguimientoDebilidades2;
    }

    public String getSeguimientoAnterior() {
        return seguimientoAnterior;
    }

    public void setSeguimientoAnterior(String seguimientoAnterior) {
        this.seguimientoAnterior = seguimientoAnterior;
    }

    public String getConclusionesRecomendaciones() {
        return conclusionesRecomendaciones;
    }

    public void setConclusionesRecomendaciones(String conclusionesRecomendaciones) {
        this.conclusionesRecomendaciones = conclusionesRecomendaciones;
    }

    public String getFechaInicioAuditoria() {
        return fechaInicioAuditoria;
    }

    public void setFechaInicioAuditoria(String fechaInicioAuditoria) {
        this.fechaInicioAuditoria = fechaInicioAuditoria;
    }

    public String getFechaFinAuditoria() {
        return fechaFinAuditoria;
    }

    public void setFechaFinAuditoria(String fechaFinAuditoria) {
        this.fechaFinAuditoria = fechaFinAuditoria;
    }

    public String getAnexo1() {
        return anexo1;
    }

    public void setAnexo1(String anexo1) {
        this.anexo1 = anexo1;
    }

    public String getAnexo2() {
        return anexo2;
    }

    public void setAnexo2(String anexo2) {
        this.anexo2 = anexo2;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setDebilidades(String debilidades) {
        this.debilidades = debilidades;
    }

    public String getDebilidades() {
        return debilidades;
    }

    public String getEquiposTrabajos() {
        return equiposTrabajos;
    }

    public void setEquiposTrabajos(String equiposTrabajos) {
        this.equiposTrabajos = equiposTrabajos;
    }
}