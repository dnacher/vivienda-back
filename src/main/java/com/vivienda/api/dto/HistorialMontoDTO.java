package com.vivienda.api.dto;

import java.util.Date;

public class HistorialMontoDTO {

    private Integer id;
    private MontoDTO monto;
    private Date fechaActualizacion;
    private Integer valorPesos;
    private Boolean activo;

    public HistorialMontoDTO(){}

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

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getValorPesos() {
        return valorPesos;
    }

    public void setValorPesos(Integer valorPesos) {
        this.valorPesos = valorPesos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
