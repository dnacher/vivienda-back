package com.vivienda.domain.mappers;

import com.vivienda.api.dto.MontoDTO;
import com.vivienda.persistence.model.Monto;
import org.springframework.stereotype.Component;

@Component
public class MontoMapper implements AbstractMapper<Monto, MontoDTO>{

    @Override
    public Monto mapToEntity(MontoDTO dto) {
        Monto monto = new Monto();
        monto.setId(dto.getId());
        monto.setActivo(dto.getActivo());
        monto.setDescripcion(dto.getDescripcion());
        monto.setFechaActualizacion(dto.getFechaActualizacion());
        monto.setSimbolo(dto.getSimbolo());
        monto.setTipoMonto(dto.getTipoMonto());
        monto.setValorPesos(dto.getValorPesos());
        return monto;
    }

    @Override
    public MontoDTO mapToDTO(Monto entity) {
        MontoDTO monto = new MontoDTO();
        monto.setId(entity.getId());
        monto.setActivo(entity.getActivo());
        monto.setDescripcion(entity.getDescripcion());
        monto.setFechaActualizacion(entity.getFechaActualizacion());
        monto.setSimbolo(entity.getSimbolo());
        monto.setTipoMonto(entity.getTipoMonto());
        monto.setValorPesos(entity.getValorPesos());
        return monto;
    }
}
