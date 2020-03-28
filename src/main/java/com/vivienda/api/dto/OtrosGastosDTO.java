package com.vivienda.api.dto;

import java.util.Date;

public class OtrosGastosDTO {

    private Integer id;
    private ConceptoDTO concepto;
    private MontoDTO monto;
    private UnidadDTO unidad;
    private Integer secuencia;
    private String descripcion;
    private Integer monto_1;
    private Date fecha;
    private Boolean pago;
    private boolean activo;

    public OtrosGastosDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConceptoDTO getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoDTO concepto) {
        this.concepto = concepto;
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

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getMonto_1() {
        return monto_1;
    }

    public void setMonto_1(Integer monto_1) {
        this.monto_1 = monto_1;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
