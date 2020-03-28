package com.vivienda.domain.mappers;

import com.vivienda.api.dto.UnidadDTO;
import com.vivienda.persistence.model.Unidad;
import org.springframework.stereotype.Component;

@Component
public class UnidadMapper implements AbstractMapper<Unidad, UnidadDTO>{

    @Override
    public Unidad mapToEntity(UnidadDTO dto) {
        Unidad unidad = new Unidad();
        unidad.setActivo(dto.getActivo());
        unidad.setApellido(dto.getApellido());
        unidad.setBlock(dto.getBlock());
        unidad.setEsEdificio(dto.getEsEdificio());
        unidad.setFechaIngreso(dto.getFechaIngreso());
        unidad.setHabitaciones(dto.getHabitaciones());
        unidad.setId(dto.getId());
        unidad.setMail(dto.getMail());
        unidad.setNombre(dto.getNombre());
        unidad.setPropietarioInquilino(dto.getPropietarioInquilino());
        unidad.setPuerta(dto.getPuerta());
        unidad.setTelefono(dto.getTelefono());
        unidad.setTorre(dto.getTorre());
        return unidad;
    }

    @Override
    public UnidadDTO mapToDTO(Unidad entity) {
        UnidadDTO unidad = new UnidadDTO();
        unidad.setActivo(entity.getActivo());
        unidad.setApellido(entity.getApellido());
        unidad.setBlock(entity.getBlock());
        unidad.setEsEdificio(entity.getEsEdificio());
        unidad.setFechaIngreso(entity.getFechaIngreso());
        unidad.setHabitaciones(entity.getHabitaciones());
        unidad.setId(entity.getId());
        unidad.setMail(entity.getMail());
        unidad.setNombre(entity.getNombre());
        unidad.setPropietarioInquilino(entity.getPropietarioInquilino());
        unidad.setPuerta(entity.getPuerta());
        unidad.setTelefono(entity.getTelefono());
        unidad.setTorre(entity.getTorre());
        return unidad;
    }
}
