package com.vivienda.domain.mappers;

import com.vivienda.api.dto.ConvenioDTO;
import com.vivienda.persistence.model.Convenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvenioMapper implements AbstractMapper<Convenio, ConvenioDTO>{

    @Autowired
    private UnidadMapper unidadMapper;

    @Autowired
    private ReglaBonificacionMapper reglaBonificacionMapper;

    @Autowired
    private MontoMapper montoMapper;

    @Override
    public Convenio mapToEntity(ConvenioDTO dto) {
        Convenio convenio = new Convenio();
        convenio.setId(dto.getId());
        convenio.setUnidad(unidadMapper.mapToEntity(dto.getUnidad()));
        convenio.setActivo(dto.getActivo());
        convenio.setCuotas(dto.getCuotas());
        convenio.setDescripcion(dto.getDescripcion());
        convenio.setDeudaTotal(dto.getDeudaTotal());
        convenio.setReglabonificacion(reglaBonificacionMapper.mapToEntity(dto.getReglaBonificacion()));
        convenio.setMonto(montoMapper.mapToEntity(dto.getMonto()));
        convenio.setSaldoInicial(dto.getSaldoInicial());
        return convenio;
    }

    @Override
    public ConvenioDTO mapToDTO(Convenio entity) {
        ConvenioDTO convenioDTO = new ConvenioDTO();
        convenioDTO.setId(entity.getId());
        convenioDTO.setUnidad(unidadMapper.mapToDTO(entity.getUnidad()));
        convenioDTO.setActivo(entity.getActivo());
        convenioDTO.setCuotas(entity.getCuotas());
        convenioDTO.setDescripcion(entity.getDescripcion());
        convenioDTO.setDeudaTotal(entity.getDeudaTotal());
        convenioDTO.setReglaBonificacion(reglaBonificacionMapper.mapToDTO(entity.getReglabonificacion()));
        convenioDTO.setMonto(montoMapper.mapToDTO(entity.getMonto()));
        convenioDTO.setSaldoInicial(entity.getSaldoInicial());
        return convenioDTO;
    }
}
