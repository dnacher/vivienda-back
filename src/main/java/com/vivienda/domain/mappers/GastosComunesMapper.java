package com.vivienda.domain.mappers;

import com.vivienda.api.dto.GastosComunesDTO;
import com.vivienda.persistence.model.GastosComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GastosComunesMapper implements AbstractMapper<GastosComunes, GastosComunesDTO>{

    @Autowired
    private MontoMapper montoMapper;

    @Autowired
    private UnidadMapper unidadMapper;

    @Override
    public GastosComunes mapToEntity(GastosComunesDTO dto) {
        GastosComunes gastosComunes = new GastosComunes();
        gastosComunes.setId(dto.getId());
        gastosComunes.setActivo(dto.getActivo());
        gastosComunes.setDescripcion(dto.getDescripcion());
        gastosComunes.setBonificacion(dto.getBonificacion());
        gastosComunes.setDescuento(dto.getDescuento());
        gastosComunes.setEstado(dto.getEstado());
        gastosComunes.setFechaPago(dto.getFechaPago());
        gastosComunes.setMonto(montoMapper.mapToEntity(dto.getMonto()));
        gastosComunes.setPeriodo(dto.getPeriodo());
        gastosComunes.setUnidad(unidadMapper.mapToEntity(dto.getUnidad()));
        gastosComunes.setValor(dto.getMonto_1());
        return gastosComunes;
    }

    @Override
    public GastosComunesDTO mapToDTO(GastosComunes entity) {
        GastosComunesDTO gastosComunes = new GastosComunesDTO();
        gastosComunes.setId(entity.getId());
        gastosComunes.setActivo(entity.getActivo());
        gastosComunes.setDescripcion(entity.getDescripcion());
        gastosComunes.setBonificacion(entity.getBonificacion());
        gastosComunes.setDescuento(entity.getDescuento());
        gastosComunes.setEstado(entity.getEstado());
        gastosComunes.setFechaPago(entity.getFechaPago());
        gastosComunes.setMonto(montoMapper.mapToDTO(entity.getMonto()));
        gastosComunes.setPeriodo(entity.getPeriodo());
        gastosComunes.setUnidad(unidadMapper.mapToDTO(entity.getUnidad()));
        gastosComunes.setMonto_1(entity.getValor());
        return gastosComunes;
    }

}
