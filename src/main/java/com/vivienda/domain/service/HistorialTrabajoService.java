package com.vivienda.domain.service;

import com.vivienda.api.dto.HistorialTrabajoDTO;
import com.vivienda.domain.mappers.HistorialTrabajoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.HistorialTrabajoDAO;
import com.vivienda.persistence.model.HistorialTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistorialTrabajoService {
    
    private final HistorialTrabajoDAO historialTrabajoDAO;

    private final HistorialTrabajoMapper historialTrabajoMapper;


    @Autowired
    public HistorialTrabajoService(HistorialTrabajoMapper historialTrabajoMapper, HistorialTrabajoDAO historialTrabajoDAO){
        this.historialTrabajoDAO = historialTrabajoDAO;
        this.historialTrabajoMapper = historialTrabajoMapper;
    }

    public HistorialTrabajoDTO saveHistorialTrabajo(HistorialTrabajoDTO historialTrabajoDTO) throws ServiceException {
        HistorialTrabajo HistorialTrabajo = historialTrabajoMapper.mapToEntity(historialTrabajoDTO);
        return historialTrabajoMapper.mapToDTO(this.historialTrabajoDAO.saveHistorialTrabajo(HistorialTrabajo));
    }

    public void deleteHistorialTrabajo(HistorialTrabajoDTO historialTrabajoDTO){
        this.historialTrabajoDAO.deleteHistorialTrabajo(historialTrabajoDTO.getId());
    }

    public HistorialTrabajoDTO updateHistorialTrabajo(HistorialTrabajoDTO historialTrabajoDTO) throws ServiceException{
        try {
            return this.historialTrabajoMapper.mapToDTO(this.historialTrabajoDAO.updateHistorialTrabajo(historialTrabajoMapper.mapToEntity(historialTrabajoDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<HistorialTrabajoDTO> getHistorialTrabajo(){
        List<HistorialTrabajo> HistorialTrabajos = this.historialTrabajoDAO.getHistorialTrabajos();
        return HistorialTrabajos.stream().map(historialTrabajo -> this.historialTrabajoMapper.mapToDTO(historialTrabajo)).collect(Collectors.toList());
    }

    public HistorialTrabajoDTO getHistorialTrabajoById(Integer id) throws ServiceException{
        return this.historialTrabajoMapper.mapToDTO(this.historialTrabajoDAO.getHistorialTrabajoById(id));
    }
}
