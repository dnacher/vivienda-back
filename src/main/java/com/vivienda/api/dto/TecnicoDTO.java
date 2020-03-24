package com.vivienda.api.dto;

import java.util.Date;

public class TecnicoDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    private Integer calificacion;
    private Integer estado;
    private Date fechaInicioEstado;
    private Date fechaFinEstado;
    private Boolean activo;

    public TecnicoDTO(){}

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechaInicioEstado() {
        return fechaInicioEstado;
    }

    public void setFechaInicioEstado(Date fechaInicioEstado) {
        this.fechaInicioEstado = fechaInicioEstado;
    }

    public Date getFechaFinEstado() {
        return fechaFinEstado;
    }

    public void setFechaFinEstado(Date fechaFinEstado) {
        this.fechaFinEstado = fechaFinEstado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
