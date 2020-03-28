package com.vivienda.api.dto;

import com.vivienda.persistence.model.PermisoUsuario;

public class TipoDuracionDTO {

    private Integer id;
    private String nombre;
    private boolean activo;
    private String descripcion;
    private PermisoUsuario permisoUsuario;

    public TipoDuracionDTO(){}

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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public PermisoUsuario getPermisoUsuario() {
        return permisoUsuario;
    }

    public void setPermisoUsuario(PermisoUsuario permisoUsuario) {
        this.permisoUsuario = permisoUsuario;
    }
}
