package com.vivienda.domain.mappers;

import com.vivienda.api.dto.HistorialMontoDTO;
import com.vivienda.persistence.model.HistorialMonto;
import org.springframework.stereotype.Component;

@Component
public class HistorialMontoMapper implements AbstractMapper<HistorialMonto, HistorialMontoDTO>{

    @Override
    public HistorialMonto mapToEntity(HistorialMontoDTO dto) {
        HistorialMonto historialMonto = new HistorialMonto();
        historialMonto.setId(dto.getId());
        historialMonto.setActivo(dto.getActivo());
        historialMonto.setFechaActualizacion(dto.getFechaActualizacion());
        historialMonto.setMonto(dto.getMonto());
        historialMonto.setValorPesos(dto.getValorPesos());
        return historialMonto;
    }

    @Override
    public HistorialMontoDTO mapToDTO(HistorialMonto entity) {
        HistorialMontoDTO historialMonto = new HistorialMontoDTO();
        historialMonto.setId(entity.getId());
        historialMonto.setActivo(entity.getActivo());
        historialMonto.setFechaActualizacion(entity.getFechaActualizacion());
        historialMonto.setMonto(entity.getMonto());
        historialMonto.setValorPesos(entity.getValorPesos());
        return historialMonto;
    }
}
