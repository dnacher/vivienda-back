package com.vivienda.domain.mappers;

import com.vivienda.api.dto.OtrosGastosDTO;
import com.vivienda.persistence.model.OtrosGastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtrosGastosMapper implements AbstractMapper<OtrosGastos, OtrosGastosDTO>{

    @Autowired
    private ConceptoMapper conceptoMapper;

    @Autowired
    private MontoMapper montoMapper;

    @Autowired
    private UnidadMapper unidadMapper;

    @Override
    public OtrosGastos mapToEntity(OtrosGastosDTO dto) {
        OtrosGastos otrosGastos = new OtrosGastos();
        otrosGastos.setActivo(dto.getActivo());
        otrosGastos.setConcepto(conceptoMapper.mapToEntity(dto.getConcepto()));
        otrosGastos.setDescripcion(dto.getDescripcion());
        otrosGastos.setFecha(dto.getFecha());
        otrosGastos.setId(dto.getId());
        otrosGastos.setMonto(montoMapper.mapToEntity(dto.getMonto()));
        otrosGastos.setValor(dto.getMonto_1());
        otrosGastos.setPago(dto.getPago());
        otrosGastos.setSecuencia(dto.getSecuencia());
        otrosGastos.setUnidad(unidadMapper.mapToEntity(dto.getUnidad()));
        return otrosGastos;
    }

    @Override
    public OtrosGastosDTO mapToDTO(OtrosGastos entity) {
        OtrosGastosDTO otrosGastos = new OtrosGastosDTO();
        otrosGastos.setActivo(entity.getActivo());
        otrosGastos.setConcepto(conceptoMapper.mapToDTO(entity.getConcepto()));
        otrosGastos.setDescripcion(entity.getDescripcion());
        otrosGastos.setFecha(entity.getFecha());
        otrosGastos.setId(entity.getId());
        otrosGastos.setMonto(montoMapper.mapToDTO(entity.getMonto()));
        otrosGastos.setMonto_1(entity.getValor());
        otrosGastos.setPago(entity.getPago());
        otrosGastos.setSecuencia(entity.getSecuencia());
        otrosGastos.setUnidad(unidadMapper.mapToDTO(entity.getUnidad()));
        return otrosGastos;
    }
}
