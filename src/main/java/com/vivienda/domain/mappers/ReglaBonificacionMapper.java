package com.vivienda.domain.mappers;

import com.vivienda.api.dto.ReglaBonificacionDTO;
import com.vivienda.persistence.model.ReglaBonificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReglaBonificacionMapper implements AbstractMapper<ReglaBonificacion, ReglaBonificacionDTO>{

    @Autowired
    private MontoMapper montoMapper;

    @Override
    public ReglaBonificacion mapToEntity(ReglaBonificacionDTO dto) {
        ReglaBonificacion reglaBonificacion = new ReglaBonificacion();
        reglaBonificacion.setId(dto.getId());
        reglaBonificacion.setActivo(dto.getActivo());
        reglaBonificacion.setDescripcion(dto.getDescripcion());
        reglaBonificacion.setDiaApagar(dto.getDiaApagar());
        reglaBonificacion.setHabitaciones(dto.getHabitaciones());
        reglaBonificacion.setMonto(montoMapper.mapToEntity(dto.getMonto()));
        reglaBonificacion.setTipoBonificacion(dto.getTipoBonificacion());
        reglaBonificacion.setValor(dto.getValor());
        return reglaBonificacion;
    }

    @Override
    public ReglaBonificacionDTO mapToDTO(ReglaBonificacion entity) {
        ReglaBonificacionDTO reglaBonificacion = new ReglaBonificacionDTO();
        reglaBonificacion.setId(entity.getId());
        reglaBonificacion.setActivo(entity.getActivo());
        reglaBonificacion.setDescripcion(entity.getDescripcion());
        reglaBonificacion.setDiaApagar(entity.getDiaApagar());
        reglaBonificacion.setHabitaciones(entity.getHabitaciones());
        reglaBonificacion.setMonto(montoMapper.mapToDTO(entity.getMonto()));
        reglaBonificacion.setTipoBonificacion(entity.getTipoBonificacion());
        reglaBonificacion.setValor(entity.getValor());
        return reglaBonificacion;
    }
}
