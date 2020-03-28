package com.vivienda.domain.mappers;

import com.vivienda.api.dto.HistorialMontoDTO;
import com.vivienda.persistence.model.HistorialMonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistorialMontoMapper implements AbstractMapper<HistorialMonto, HistorialMontoDTO>{

    @Autowired
    private MontoMapper montoMapper;

    @Override
    public HistorialMonto mapToEntity(HistorialMontoDTO dto) {
        HistorialMonto historialMonto = new HistorialMonto();
        historialMonto.setId(dto.getId());
        historialMonto.setActivo(dto.getActivo());
        historialMonto.setFechaActualizacion(dto.getFechaActualizacion());
        historialMonto.setMonto(montoMapper.mapToEntity(dto.getMonto()));
        historialMonto.setValorPesos(dto.getValorPesos());
        return historialMonto;
    }

    @Override
    public HistorialMontoDTO mapToDTO(HistorialMonto entity) {
        HistorialMontoDTO historialMonto = new HistorialMontoDTO();
        historialMonto.setId(entity.getId());
        historialMonto.setActivo(entity.getActivo());
        historialMonto.setFechaActualizacion(entity.getFechaActualizacion());
        historialMonto.setMonto(montoMapper.mapToDTO(entity.getMonto()));
        historialMonto.setValorPesos(entity.getValorPesos());
        return historialMonto;
    }
}
