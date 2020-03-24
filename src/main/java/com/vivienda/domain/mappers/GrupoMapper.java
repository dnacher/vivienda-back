package com.vivienda.domain.mappers;

import com.vivienda.api.dto.GrupoDTO;
import com.vivienda.persistence.model.Grupo;
import org.springframework.stereotype.Component;

@Component
public class GrupoMapper implements AbstractMapper<Grupo, GrupoDTO>{

    @Override
    public Grupo mapToEntity(GrupoDTO dto) {
        Grupo grupo = new Grupo();
        grupo.setId(dto.getId());
        grupo.setNombre(dto.getNombre());
        grupo.setDescripcion(dto.getDescripcion());
        grupo.setActivo(dto.getActivo());
        return grupo;
    }

    @Override
    public GrupoDTO mapToDTO(Grupo entity) {
        GrupoDTO grupo = new GrupoDTO();
        grupo.setId(entity.getId());
        grupo.setNombre(entity.getNombre());
        grupo.setDescripcion(entity.getDescripcion());
        grupo.setActivo(entity.getActivo());
        return grupo;
    }
}
