package com.vivienda.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cuota_convenio")
public class CuotaConvenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "convenio")
    private Convenio convenio;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "monto")
    private Monto monto;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "unidad")
    private Unidad unidad;

    @Column(name = "numero_cuota")
    private Integer numeroCuota;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "pago")
    private Integer pago;

    @Column(name = "tiene_bonificacion")
    private Boolean tieneBonificacion;

    @Column(name = "fecha_pago")
    private Date fechaPago;

    public CuotaConvenio(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Monto getMonto() {
        return monto;
    }

    public void setMonto(Monto monto) {
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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
