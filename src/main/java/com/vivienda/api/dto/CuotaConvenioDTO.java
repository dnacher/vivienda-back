package com.vivienda.api.dto;

import java.util.Date;

public class CuotaConvenioDTO {

    private Integer id;
    private ConvenioDTO convenio;
    private MontoDTO monto;
    private Integer numeroCuota;
    private String descripcion;
    private Integer pago;
    private Boolean tieneBonificacion;
    private Date fechaPago;

    public CuotaConvenioDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConvenioDTO getConvenio() {
        return convenio;
    }

    public void setConvenio(ConvenioDTO convenio) {
        this.convenio = convenio;
    }

    public MontoDTO getMonto() {
        return monto;
    }

    public void setMonto(MontoDTO monto) {
        this.monto = monto;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPago() {
        return pago;
    }

    public void setPago(Integer pago) {
        this.pago = pago;
    }

    public Boolean getTieneBonificacion() {
        return tieneBonificacion;
    }

    public void setTieneBonificacion(Boolean tieneBonificacion) {
        this.tieneBonificacion = tieneBonificacion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
