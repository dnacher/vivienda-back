package com.vivienda.domain.mappers;

import com.vivienda.api.dto.MaterialDTO;
import com.vivienda.persistence.model.Material;
import org.springframework.stereotype.Component;

@Component
public class MaterialMapper implements AbstractMapper<Material, MaterialDTO>{

    @Override
    public Material mapToEntity(MaterialDTO dto) {
        Material material = new Material();
        material.setId(dto.getId());
        material.setActivo(dto.getActivo());
        material.setCantidad(dto.getCantidad());
        material.setDescripcion(dto.getDescripcion());
        material.setEntrada(dto.getEntrada());
        material.setSalida(dto.getSalida());
        material.setNombre(dto.getNombre());
        return material;
    }

    @Override
    public MaterialDTO mapToDTO(Material entity) {
        MaterialDTO material = new MaterialDTO();
        material.setId(entity.getId());
        material.setActivo(entity.getActivo());
        material.setCantidad(entity.getCantidad());
        material.setDescripcion(entity.getDescripcion());
        material.setEntrada(entity.getEntrada());
        material.setSalida(entity.getSalida());
        material.setNombre(entity.getNombre());
        return material;
    }
}
