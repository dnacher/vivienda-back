package com.vivienda.domain.mappers;

import com.vivienda.api.dto.GastosComunesDTO;
import com.vivienda.persistence.model.GastosComunes;
import org.springframework.stereotype.Component;

@Component
public class GastosComunesMapper implements AbstractMapper<GastosComunes, GastosComunesDTO>{

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
        gastosComunes.setMonto(dto.getMonto());
        gastosComunes.setPeriodo(dto.getPeriodo());
        gastosComunes.setUnidad(dto.getUnidad());
        gastosComunes.setMonto_1(dto.getMonto_1());
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
        gastosComunes.setMonto(entity.getMonto());
        gastosComunes.setPeriodo(entity.getPeriodo());
        gastosComunes.setUnidad(entity.getUnidad());
        gastosComunes.setMonto_1(entity.getMonto_1());
        return gastosComunes;
    }

}
