package com.vivienda.domain.mappers;

import com.vivienda.api.dto.ListaPrecioDTO;
import com.vivienda.persistence.model.ListaPrecio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaPrecioMapper implements AbstractMapper<ListaPrecio, ListaPrecioDTO>{

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public ListaPrecio mapToEntity(ListaPrecioDTO dto) {
        ListaPrecio listaPrecio = new ListaPrecio();
        listaPrecio.setId(dto.getId());
        listaPrecio.setActivo(dto.getActivo());
        listaPrecio.setCantidad(dto.getCantidad());
        listaPrecio.setFecha(dto.getFecha());
        listaPrecio.setMaterial(materialMapper.mapToEntity(dto.getMaterial()));
        listaPrecio.setPrecio(dto.getPrecio());
        return listaPrecio;
    }

    @Override
    public ListaPrecioDTO mapToDTO(ListaPrecio entity) {
        ListaPrecioDTO listaPrecio = new ListaPrecioDTO();
        listaPrecio.setId(entity.getId());
        listaPrecio.setActivo(entity.getActivo());
        listaPrecio.setCantidad(entity.getCantidad());
        listaPrecio.setFecha(entity.getFecha());
        listaPrecio.setMaterial(materialMapper.mapToDTO(entity.getMaterial()));
        listaPrecio.setPrecio(entity.getPrecio());
        return listaPrecio;
    }
}
