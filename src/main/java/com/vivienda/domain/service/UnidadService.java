package com.vivienda.domain.service;

import com.vivienda.api.dto.UnidadDTO;
import com.vivienda.domain.mappers.UnidadMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.UnidadDAO;
import com.vivienda.persistence.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnidadService {

    private final UnidadDAO unidadDAO;

    private final UnidadMapper unidadMapper;


    @Autowired
    public UnidadService(UnidadMapper unidadMapper, UnidadDAO unidadDAO){
        this.unidadDAO = unidadDAO;
        this.unidadMapper = unidadMapper;
    }

    public UnidadDTO saveUnidad(UnidadDTO unidadDTO) throws ServiceException {
        Unidad Unidad = unidadMapper.mapToEntity(unidadDTO);
        return unidadMapper.mapToDTO(this.unidadDAO.saveUnidad(Unidad));
    }

    public void deleteUnidad(UnidadDTO unidadDTO){
        this.unidadDAO.deleteUnidad(unidadDTO.getId());
    }

    public UnidadDTO updateUnidad(UnidadDTO unidadDTO) throws ServiceException{
        try {
            return this.unidadMapper.mapToDTO(this.unidadDAO.updateUnidad(unidadMapper.mapToEntity(unidadDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<UnidadDTO> getUnidades(){
        List<Unidad> Unidads = this.unidadDAO.getUnidades();
        return Unidads.stream().map(unidad -> this.unidadMapper.mapToDTO(unidad)).collect(Collectors.toList());
    }

    public UnidadDTO getUnidadById(Integer id) throws ServiceException{
        return this.unidadMapper.mapToDTO(this.unidadDAO.getUnidadById(id));
    }
}
