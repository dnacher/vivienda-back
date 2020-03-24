package com.vivienda.domain.mappers;

import com.vivienda.api.dto.CuotaConvenioDTO;
import com.vivienda.persistence.model.CuotaConvenio;
import org.springframework.stereotype.Component;

@Component
public class CuotaConvenioMapper implements AbstractMapper<CuotaConvenio, CuotaConvenioDTO>{

    @Override
    public CuotaConvenio mapToEntity(CuotaConvenioDTO dto) {
        CuotaConvenio cuotaConvenio = new CuotaConvenio();
        cuotaConvenio.setConvenio(dto.getConvenio());
        cuotaConvenio.setDescripcion(dto.getDescripcion());
        cuotaConvenio.setFechaPago(dto.getFechaPago());
        cuotaConvenio.setId(dto.getId());
        cuotaConvenio.setMonto(dto.getMonto());
        cuotaConvenio.setNumeroCuota(dto.getNumeroCuota());
        cuotaConvenio.setPago(dto.getPago());
        cuotaConvenio.setTieneBonificacion(dto.getTieneBonificacion());
        return cuotaConvenio;
    }

    @Override
    public CuotaConvenioDTO mapToDTO(CuotaConvenio entity) {
        CuotaConvenioDTO cuotaConvenio = new CuotaConvenioDTO();
        cuotaConvenio.setConvenio(entity.getConvenio());
        cuotaConvenio.setDescripcion(entity.getDescripcion());
        cuotaConvenio.setFechaPago(entity.getFechaPago());
        cuotaConvenio.setId(entity.getId());
        cuotaConvenio.setMonto(entity.getMonto());
        cuotaConvenio.setNumeroCuota(entity.getNumeroCuota());
        cuotaConvenio.setPago(entity.getPago());
        cuotaConvenio.setTieneBonificacion(entity.getTieneBonificacion());
        return cuotaConvenio;
    }
}
