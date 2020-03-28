package com.vivienda.domain.mappers;

import com.vivienda.api.dto.TecnicoDTO;
import com.vivienda.persistence.model.Tecnico;
import org.springframework.stereotype.Component;

@Component
public class TecnicoMapper implements AbstractMapper<Tecnico, TecnicoDTO>{

    @Override
    public Tecnico mapToEntity(TecnicoDTO dto) {
        Tecnico tecnico = new Tecnico();
        tecnico.setId(dto.getId());
        tecnico.setActivo(dto.getActivo());
        tecnico.setCalificacion(dto.getCalificacion());
        tecnico.setApellido(dto.getApellido());
        tecnico.setEstado(dto.getEstado());
        tecnico.setFechaFinEstado(dto.getFechaFinEstado());
        tecnico.setFechaInicioEstado(dto.getFechaInicioEstado());
        tecnico.setMail(dto.getMail());
        tecnico.setNombre(dto.getNombre());
        tecnico.setTelefono(dto.getTelefono());
        return tecnico;
    }

    @Override
    public TecnicoDTO mapToDTO(Tecnico entity) {
        TecnicoDTO tecnico = new TecnicoDTO();
        tecnico.setId(entity.getId());
        tecnico.setActivo(entity.getActivo());
        tecnico.setCalificacion(entity.getCalificacion());
        tecnico.setApellido(entity.getApellido());
        tecnico.setEstado(entity.getEstado());
        tecnico.setFechaFinEstado(entity.getFechaFinEstado());
        tecnico.setFechaInicioEstado(entity.getFechaInicioEstado());
        tecnico.setMail(entity.getMail());
        tecnico.setNombre(entity.getNombre());
        tecnico.setTelefono(entity.getTelefono());
        return tecnico;
    }
}
