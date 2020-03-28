package com.vivienda.api.dto;

public class ConvenioDTO {

    private Integer id;
    private MontoDTO monto;
    private ReglaBonificacionDTO reglaBonificacion;
    private UnidadDTO unidad;
    private Integer deudaTotal;
    private Integer cuotas;
    private Integer saldoInicial;
    private String descripcion;
    private Boolean activo;

    public ConvenioDTO(){}

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

    public ReglaBonificacionDTO getReglaBonificacion() {
        return reglaBonificacion;
    }

    public void setReglaBonificacion(ReglaBonificacionDTO reglaBonificacion) {
        this.reglaBonificacion = reglaBonificacion;
    }

    public UnidadDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }

    public Integer getDeudaTotal() {
        return deudaTotal;
    }

    public void setDeudaTotal(Integer deudaTotal) {
        this.deudaTotal = deudaTotal;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Integer getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Integer saldoInicial) {
        this.saldoInicial = saldoInicial;
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
