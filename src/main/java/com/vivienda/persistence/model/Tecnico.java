package com.vivienda.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mail")
    private String mail;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "fecha_inicio_estado")
    private Date fechaInicioEstado;

    @Column(name = "fecha_fin_estado")
    private Date fechaFinEstado;

    @Column(name = "activo")
    private Boolean activo;

    public Tecnico(){}

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
