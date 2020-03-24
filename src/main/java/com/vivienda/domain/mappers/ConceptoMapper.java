package com.vivienda.domain.mappers;

import com.vivienda.api.dto.ConceptoDTO;
import com.vivienda.persistence.model.Concepto;
import org.springframework.stereotype.Component;

@Component
public class ConceptoMapper implements AbstractMapper<Concepto, ConceptoDTO>{

    @Override
    public Concepto mapToEntity(ConceptoDTO dto) {
        Concepto concepto = new Concepto();
        concepto.setId(dto.getId());
        concepto.setNombre(dto.getNombre());
        concepto.setDescripcion(dto.getDescripcion());
        concepto.setActivo(dto.getActivo());
        return concepto;
    }

    @Override
    public ConceptoDTO mapToDTO(Concepto entity) {
        ConceptoDTO concepto = new ConceptoDTO();
        concepto.setId(entity.getId());
        concepto.setNombre(entity.getNombre());
        concepto.setDescripcion(entity.getDescripcion());
        concepto.setActivo(entity.getActivo());
        return concepto;
    }
}
