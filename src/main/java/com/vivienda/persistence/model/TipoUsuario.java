package com.vivienda.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private boolean activo;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "permiso_usuario")
    private PermisoUsuario permisoUsuario;

    public TipoUsuario(){}
   
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

    public PermisoUsuario getPermisoUsuario() {
        return permisoUsuario;
    }

    public void setPermisoUsuario(PermisoUsuario permisoUsuario) {
        this.permisoUsuario = permisoUsuario;
    }


    // </editor-fold>

}


