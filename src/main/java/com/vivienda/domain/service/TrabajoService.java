package com.vivienda.domain.service;

import com.vivienda.api.dto.TrabajoDTO;
import com.vivienda.domain.mappers.TrabajoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.TrabajoDAO;
import com.vivienda.persistence.model.Trabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabajoService {

    private final TrabajoDAO trabajoDAO;

    private final TrabajoMapper trabajoMapper;


    @Autowired
    public TrabajoService(TrabajoMapper trabajoMapper, TrabajoDAO trabajoDAO){
        this.trabajoDAO = trabajoDAO;
        this.trabajoMapper = trabajoMapper;
    }

    public TrabajoDTO saveTrabajo(TrabajoDTO trabajoDTO) throws ServiceException {
        Trabajo Trabajo = trabajoMapper.mapToEntity(trabajoDTO);
        return trabajoMapper.mapToDTO(this.trabajoDAO.saveTrabajo(Trabajo));
    }

    public void deleteTrabajo(TrabajoDTO trabajoDTO){
        this.trabajoDAO.deleteTrabajo(trabajoDTO.getId());
    }

    public TrabajoDTO updateTrabajo(TrabajoDTO trabajoDTO) throws ServiceException{
        try {
            return this.trabajoMapper.mapToDTO(this.trabajoDAO.updateTrabajo(trabajoMapper.mapToEntity(trabajoDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<TrabajoDTO> getTrabajos(){
        List<Trabajo> Trabajos = this.trabajoDAO.getTrabajos();
        return Trabajos.stream().map(trabajo -> this.trabajoMapper.mapToDTO(trabajo)).collect(Collectors.toList());
    }

    public TrabajoDTO getTrabajoById(Integer id) throws ServiceException{
        return this.trabajoMapper.mapToDTO(this.trabajoDAO.getTrabajoById(id));
    }
}
