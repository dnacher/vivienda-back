package com.vivienda.domain.mappers;

import com.vivienda.api.dto.UrgenciaDTO;
import com.vivienda.persistence.model.Urgencia;
import org.springframework.stereotype.Component;

@Component
public class UrgenciaMapper implements AbstractMapper<Urgencia, UrgenciaDTO>{

    @Override
    public Urgencia mapToEntity(UrgenciaDTO dto) {
        Urgencia urgencia = new Urgencia();
        urgencia.setId(dto.getId());
        urgencia.setNombre(dto.getNombre());
        urgencia.setDescripcion(dto.getDescripcion());
        urgencia.setActivo(dto.getActivo());
        return urgencia;
    }

    @Override
    public UrgenciaDTO mapToDTO(Urgencia entity) {
        UrgenciaDTO urgencia = new UrgenciaDTO();
        urgencia.setId(entity.getId());
        urgencia.setNombre(entity.getNombre());
        urgencia.setDescripcion(entity.getDescripcion());
        urgencia.setActivo(entity.getActivo());
        return urgencia;
    }
}
