package com.vivienda.domain.mappers;

import com.vivienda.api.dto.HistorialTrabajoDTO;
import com.vivienda.persistence.model.HistorialTrabajo;
import org.springframework.stereotype.Component;

@Component
public class HistorialTrabajoMapper implements AbstractMapper<HistorialTrabajo, HistorialTrabajoDTO>{

    @Override
    public HistorialTrabajo mapToEntity(HistorialTrabajoDTO dto) {
        HistorialTrabajo historialTrabajo = new HistorialTrabajo();
        historialTrabajo.setId(dto.getId());
        historialTrabajo.setDescripcion(dto.getDescripcion());
        historialTrabajo.setEstado(dto.getEstado());
        historialTrabajo.setFecha(dto.getFecha());
        historialTrabajo.setTecnico(dto.getTecnico());
        historialTrabajo.setTrabajo(dto.getTrabajo());
        return historialTrabajo;
    }

    @Override
    public HistorialTrabajoDTO mapToDTO(HistorialTrabajo entity) {
        HistorialTrabajoDTO historialTrabajo = new HistorialTrabajoDTO();
        historialTrabajo.setId(entity.getId());
        historialTrabajo.setDescripcion(entity.getDescripcion());
        historialTrabajo.setEstado(entity.getEstado());
        historialTrabajo.setFecha(entity.getFecha());
        historialTrabajo.setTecnico(entity.getTecnico());
        historialTrabajo.setTrabajo(entity.getTrabajo());
        return historialTrabajo;
    }
}
