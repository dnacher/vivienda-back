package com.vivienda.domain.service;

import com.vivienda.api.dto.HistorialMontoDTO;
import com.vivienda.domain.mappers.HistorialMontoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.HistorialMontoDAO;
import com.vivienda.persistence.model.HistorialMonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistorialMontoService {

    private final HistorialMontoDAO historialMontoDAO;

    private final HistorialMontoMapper historialMontoMapper;


    @Autowired
    public HistorialMontoService(HistorialMontoMapper historialMontoMapper, HistorialMontoDAO historialMontoDAO){
        this.historialMontoDAO = historialMontoDAO;
        this.historialMontoMapper = historialMontoMapper;
    }

    public HistorialMontoDTO saveHistorialMonto(HistorialMontoDTO historialMontoDTO) throws ServiceException {
        HistorialMonto HistorialMonto = historialMontoMapper.mapToEntity(historialMontoDTO);
        return historialMontoMapper.mapToDTO(this.historialMontoDAO.saveHistorialMonto(HistorialMonto));
    }

    public void deleteHistorialMonto(HistorialMontoDTO historialMontoDTO){
        this.historialMontoDAO.deleteHistorialMonto(historialMontoDTO.getId());
    }

    public HistorialMontoDTO updateHistorialMonto(HistorialMontoDTO historialMontoDTO) throws ServiceException{
        try {
            return this.historialMontoMapper.mapToDTO(this.historialMontoDAO.updateHistorialMonto(historialMontoMapper.mapToEntity(historialMontoDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<HistorialMontoDTO> getHistorialMontos(){
        List<HistorialMonto> HistorialMontos = this.historialMontoDAO.getHistorialMontos();
        return HistorialMontos.stream().map(historialMonto -> this.historialMontoMapper.mapToDTO(historialMonto)).collect(Collectors.toList());
    }

    public HistorialMontoDTO getHistorialMontoById(Integer id) throws ServiceException{
        return this.historialMontoMapper.mapToDTO(this.historialMontoDAO.getHistorialMontoById(id));
    }
}
