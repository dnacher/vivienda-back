package com.vivienda.api.dto;

import java.util.Date;

public class TrabajoDTO {

    private Integer id;
    private EstadoDTO estado;
    private GrupoDTO grupo;
    private TipoDuracionDTO tipoduracion;
    private UnidadDTO unidad;
    private UrgenciaDTO urgencia;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaVisita;
    private Integer calificacion;
    private Integer duracionEstimada;
    private Integer duracionReal;
    private Boolean activo;

    public TrabajoDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }

    public TipoDuracionDTO getTipoduracion() {
        return tipoduracion;
    }

    public void setTipoduracion(TipoDuracionDTO tipoduracion) {
        this.tipoduracion = tipoduracion;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }

    public UrgenciaDTO getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(UrgenciaDTO urgencia) {
        this.urgencia = urgencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(Integer duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Integer getDuracionReal() {
        return duracionReal;
    }

    public void setDuracionReal(Integer duracionReal) {
        this.duracionReal = duracionReal;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
