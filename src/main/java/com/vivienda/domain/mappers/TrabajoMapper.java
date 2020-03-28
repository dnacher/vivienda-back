package com.vivienda.domain.mappers;

import com.vivienda.api.dto.TrabajoDTO;
import com.vivienda.persistence.model.Trabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrabajoMapper implements AbstractMapper<Trabajo, TrabajoDTO>{

    @Autowired
    private EstadoMapper estadoMapper;

    @Autowired
    private TipoDuracionMapper tipoDuracionMapper;

    @Autowired
    private UnidadMapper unidadMapper;

    @Autowired
    private UrgenciaMapper urgenciaMapper;

    @Override
    public Trabajo mapToEntity(TrabajoDTO dto) {
        Trabajo trabajo = new Trabajo();
        trabajo.setId(dto.getId());
        trabajo.setActivo(dto.getActivo());
        trabajo.setCalificacion(dto.getCalificacion());
        trabajo.setDuracionEstimada(dto.getDuracionEstimada());
        trabajo.setDescripcion(dto.getDescripcion());
        trabajo.setEstado(estadoMapper.mapToEntity(dto.getEstado()));
        trabajo.setDuracionReal(dto.getDuracionReal());
        trabajo.setFechaCreacion(dto.getFechaCreacion());
        trabajo.setTipoduracion(tipoDuracionMapper.mapToEntity(dto.getTipoduracion()));
        trabajo.setUnidad(unidadMapper.mapToEntity(dto.getUnidad()));
        trabajo.setUrgencia(urgenciaMapper.mapToEntity(dto.getUrgencia()));
        return trabajo;
    }

    @Override
    public TrabajoDTO mapToDTO(Trabajo entity) {
        TrabajoDTO trabajo = new TrabajoDTO();
        trabajo.setId(entity.getId());
        trabajo.setActivo(entity.getActivo());
        trabajo.setCalificacion(entity.getCalificacion());
        trabajo.setDuracionEstimada(entity.getDuracionEstimada());
        trabajo.setDescripcion(entity.getDescripcion());
        trabajo.setEstado(estadoMapper.mapToDTO(entity.getEstado()));
        trabajo.setDuracionReal(entity.getDuracionReal());
        trabajo.setFechaCreacion(entity.getFechaCreacion());
        trabajo.setTipoduracion(tipoDuracionMapper.mapToDTO(entity.getTipoduracion()));
        trabajo.setUnidad(unidadMapper.mapToDTO(entity.getUnidad()));
        trabajo.setUrgencia(urgenciaMapper.mapToDTO(entity.getUrgencia()));
        return trabajo;
    }
}
