package com.vivienda.domain.service;

import com.vivienda.api.dto.MontoDTO;
import com.vivienda.domain.mappers.MontoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.MontoDAO;
import com.vivienda.persistence.model.Monto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MontoService {

    private final MontoDAO montoDAO;

    private final MontoMapper montoMapper;


    @Autowired
    public MontoService(MontoMapper montoMapper, MontoDAO montoDAO){
        this.montoDAO = montoDAO;
        this.montoMapper = montoMapper;
    }

    public MontoDTO saveMonto(MontoDTO montoDTO) throws ServiceException {
        Monto Monto = montoMapper.mapToEntity(montoDTO);
        return montoMapper.mapToDTO(this.montoDAO.saveMonto(Monto));
    }

    public void deleteMonto(MontoDTO montoDTO){
        this.montoDAO.deleteMonto(montoDTO.getId());
    }

    public MontoDTO updateMonto(MontoDTO montoDTO) throws ServiceException{
        try {
            return this.montoMapper.mapToDTO(this.montoDAO.updateMonto(montoMapper.mapToEntity(montoDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<MontoDTO> getMontos(){
        List<Monto> Montos = this.montoDAO.getMontos();
        return Montos.stream().map(monto -> this.montoMapper.mapToDTO(monto)).collect(Collectors.toList());
    }

    public MontoDTO getMontoById(Integer id) throws ServiceException{
        return this.montoMapper.mapToDTO(this.montoDAO.getMontoById(id));
    }
}
