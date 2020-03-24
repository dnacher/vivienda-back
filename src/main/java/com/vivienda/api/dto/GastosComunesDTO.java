package com.vivienda.api.dto;

import java.util.Date;

public class GastosComunesDTO {

    private Integer id;

    private MontoDTO monto;

    private UnidadDTO unidad;

    private Integer monto_1;

    private Boolean isBonificacion;

    private Integer descuento;

    private Integer estado;

    private Date fechaPago;

    private Integer periodo;

    private String descripcion;

    private Boolean activo;

    public GastosComunesDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MontoDTO getMonto() {
        return monto;
    }

    public void setMonto(MontoDTO monto) {
        this.monto = monto;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }

    public Integer getMonto_1() {
        return monto_1;
    }

    public void setMonto_1(Integer monto_1) {
        this.monto_1 = monto_1;
    }

    public Boolean getBonificacion() {
        return isBonificacion;
    }

    public void setBonificacion(Boolean bonificacion) {
        isBonificacion = bonificacion;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
