package com.vivienda.domain.mappers;

import com.vivienda.api.dto.ConvenioDTO;
import com.vivienda.persistence.model.Convenio;
import org.springframework.stereotype.Component;

@Component
public class ConvenioMapper implements AbstractMapper<Convenio, ConvenioDTO>{

    @Override
    public Convenio mapToEntity(ConvenioDTO dto) {
        Convenio convenio = new Convenio();
        convenio.setId(dto.getId());
        convenio.setUnidad(dto.getUnidad());
        convenio.setActivo(dto.getActivo());
        convenio.setCuotas(dto.getCuotas());
        convenio.setDescripcion(dto.getDescripcion());
        convenio.setDeudaTotal(dto.getDeudaTotal());
        convenio.setReglabonificacion(dto.getReglabonificacion());
        convenio.setMonto(dto.getMonto());
        convenio.setSaldoInicial(dto.getSaldoInicial());
    }

    @Override
    public ConvenioDTO mapToDTO(Convenio entity) {
        ConvenioDTO convenioDTO = new ConvenioDTO();
        convenioDTO.setId(entity.getId());
        convenioDTO.setUnidad(entity.getUnidad());
        convenioDTO.setActivo(entity.getActivo());
        convenioDTO.setCuotas(entity.getCuotas());
        convenioDTO.setDescripcion(entity.getDescripcion());
        convenioDTO.setDeudaTotal(entity.getDeudaTotal());
        convenioDTO.setReglabonificacion(entity.getReglabonificacion());
        convenioDTO.setMonto(entity.getMonto());
        convenioDTO.setSaldoInicial(entity.getSaldoInicial());
        return convenioDTO;
    }
}
