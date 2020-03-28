package com.vivienda.domain.mappers;

import com.vivienda.api.dto.HistorialTrabajoDTO;
import com.vivienda.persistence.model.HistorialTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistorialTrabajoMapper implements AbstractMapper<HistorialTrabajo, HistorialTrabajoDTO>{

    @Autowired
    private EstadoMapper estadoMapper;

    @Autowired
    private TecnicoMapper tecnicoMapper;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Override
    public HistorialTrabajo mapToEntity(HistorialTrabajoDTO dto) {
        HistorialTrabajo historialTrabajo = new HistorialTrabajo();
        historialTrabajo.setId(dto.getId());
        historialTrabajo.setDescripcion(dto.getDescripcion());
        historialTrabajo.setEstado(estadoMapper.mapToEntity(dto.getEstado()));
        historialTrabajo.setFecha(dto.getFecha());
        historialTrabajo.setTecnico(tecnicoMapper.mapToEntity(dto.getTecnico()));
        historialTrabajo.setTrabajo(trabajoMapper.mapToEntity(dto.getTrabajo()));
        return historialTrabajo;
    }

    @Override
    public HistorialTrabajoDTO mapToDTO(HistorialTrabajo entity) {
        HistorialTrabajoDTO historialTrabajo = new HistorialTrabajoDTO();
        historialTrabajo.setId(entity.getId());
        historialTrabajo.setDescripcion(entity.getDescripcion());
        historialTrabajo.setEstado(estadoMapper.mapToDTO(entity.getEstado()));
        historialTrabajo.setFecha(entity.getFecha());
        historialTrabajo.setTecnico(tecnicoMapper.mapToDTO(entity.getTecnico()));
        historialTrabajo.setTrabajo(trabajoMapper.mapToDTO(entity.getTrabajo()));
        return historialTrabajo;
    }
}
