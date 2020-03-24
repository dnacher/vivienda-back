package com.vivienda.api.dto;

import java.util.Date;

public class UnidadDTO {

    private Integer id;
    private String block;
    private Integer torre;
    private Integer puerta;
    private Integer habitaciones;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String mail;
    private Boolean propietarioInquilino;
    private Date fechaIngreso;
    private Boolean activo;
    private Boolean esEdificio;

    public UnidadDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Integer getTorre() {
        return torre;
    }

    public void setTorre(Integer torre) {
        this.torre = torre;
    }

    public Integer getPuerta() {
        return puerta;
    }

    public void setPuerta(Integer puerta) {
        this.puerta = puerta;
    }

    public Integer getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getPropietarioInquilino() {
        return propietarioInquilino;
    }

    public void setPropietarioInquilino(Boolean propietarioInquilino) {
        this.propietarioInquilino = propietarioInquilino;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getEsEdificio() {
        return esEdificio;
    }

    public void setEsEdificio(Boolean esEdificio) {
        this.esEdificio = esEdificio;
    }
}
