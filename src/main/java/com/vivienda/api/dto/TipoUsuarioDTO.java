package com.vivienda.api.dto;

public class TipoUsuarioDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    private PermisoUsuarioDTO permisoUsuario;

    public TipoUsuarioDTO(){}

	// <editor-fold defaultstate="collapsed" desc="Getters and Setters">

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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public PermisoUsuarioDTO getPermisoUsuario() {
        return permisoUsuario;
    }

    public void setPermisoUsuario(PermisoUsuarioDTO permisoUsuario) {
        this.permisoUsuario = permisoUsuario;
    }


    // </editor-fold>

}


