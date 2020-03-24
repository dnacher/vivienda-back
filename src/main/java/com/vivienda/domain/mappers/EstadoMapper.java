package com.vivienda.domain.mappers;

import com.vivienda.api.dto.EstadoDTO;
import com.vivienda.persistence.model.Estado;
import org.springframework.stereotype.Component;

@Component
public class EstadoMapper implements AbstractMapper<Estado, EstadoDTO>{

    @Override
    public Estado mapToEntity(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setId(dto.getId());
        estado.setNombre(dto.getNombre());
        estado.setDescripcion(dto.getDescripcion());
        estado.setOrden(dto.getOrden());
        estado.setUltimoEstado(dto.getUltimoEstado());
        estado.setActivo(dto.getActivo());
        return estado;
    }

    @Override
    public EstadoDTO mapToDTO(Estado entity) {
        EstadoDTO estado = new EstadoDTO();
        estado.setId(entity.getId());
        estado.setNombre(entity.getNombre());
        estado.setDescripcion(entity.getDescripcion());
        estado.setOrden(entity.getOrden());
        estado.setUltimoEstado(entity.getUltimoEstado());
        estado.setActivo(entity.getActivo());
        return estado;
    }
}
