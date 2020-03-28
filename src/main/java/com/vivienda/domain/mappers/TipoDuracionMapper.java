package com.vivienda.domain.mappers;

import com.vivienda.api.dto.TipoDuracionDTO;
import com.vivienda.persistence.model.TipoDuracion;
import org.springframework.stereotype.Component;

@Component
public class TipoDuracionMapper implements AbstractMapper<TipoDuracion, TipoDuracionDTO>{

    @Override
    public TipoDuracion mapToEntity(TipoDuracionDTO dto) {
        TipoDuracion tipoDuracion = new TipoDuracion();
        tipoDuracion.setId(dto.getId());
        tipoDuracion.setNombre(dto.getNombre());
        tipoDuracion.setDescripcion(dto.getDescripcion());
        tipoDuracion.setActivo(dto.getActivo());
        return tipoDuracion;
    }

    @Override
    public TipoDuracionDTO mapToDTO(TipoDuracion entity) {
        TipoDuracionDTO tipoDuracion = new TipoDuracionDTO();
        tipoDuracion.setId(entity.getId());
        tipoDuracion.setNombre(entity.getNombre());
        tipoDuracion.setDescripcion(entity.getDescripcion());
        tipoDuracion.setActivo(entity.getActivo());
        return tipoDuracion;
    }
}
