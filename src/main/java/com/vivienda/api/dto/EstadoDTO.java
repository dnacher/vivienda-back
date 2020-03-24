package com.vivienda.api.dto;

public class EstadoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer orden;
    private boolean ultimoEstado;
    private boolean activo;

    public EstadoDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public boolean isUltimoEstado() {
        return ultimoEstado;
    }

    public void setUltimoEstado(boolean ultimoEstado) {
        this.ultimoEstado = ultimoEstado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
