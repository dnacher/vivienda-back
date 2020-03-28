package com.vivienda.api.dto;

public class ReglaBonificacionDTO {

    private Integer id;
    private String descripcion;
    private Integer diaApagar;
    private Integer tipoBonificacion;
    private Integer valor;
    private MontoDTO monto;
    private Integer habitaciones;
    private boolean activo;

    public ReglaBonificacionDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDiaApagar() {
        return diaApagar;
    }

    public void setDiaApagar(Integer diaApagar) {
        this.diaApagar = diaApagar;
    }

    public Integer getTipoBonificacion() {
        return tipoBonificacion;
    }

    public void setTipoBonificacion(Integer tipoBonificacion) {
        this.tipoBonificacion = tipoBonificacion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public MontoDTO getMonto() {
        return monto;
    }

    public void setMonto(MontoDTO monto) {
        this.monto = monto;
    }

    public Integer getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
