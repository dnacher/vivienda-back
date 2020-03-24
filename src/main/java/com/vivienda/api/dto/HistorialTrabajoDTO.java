package com.vivienda.api.dto;

import java.util.Date;

public class HistorialTrabajoDTO {

    private Integer id;
    private TecnicoDTO tecnico;
    private TrabajoDTO trabajo;
    private EstadoDTO estado;
    private String descripcion;
    private Date fecha;

    public HistorialTrabajoDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TecnicoDTO getTecnico() {
        return tecnico;
    }

    public void setTecnico(TecnicoDTO tecnico) {
        this.tecnico = tecnico;
    }

    public TrabajoDTO getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(TrabajoDTO trabajo) {
        this.trabajo = trabajo;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
