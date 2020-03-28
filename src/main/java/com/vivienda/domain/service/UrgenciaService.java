package com.vivienda.domain.service;

import com.vivienda.api.dto.UrgenciaDTO;
import com.vivienda.domain.mappers.UrgenciaMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.UrgenciaDAO;
import com.vivienda.persistence.model.Urgencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UrgenciaService {

    private final UrgenciaDAO urgenciaDAO;

    private final UrgenciaMapper urgenciaMapper;


    @Autowired
    public UrgenciaService(UrgenciaMapper urgenciaMapper, UrgenciaDAO urgenciaDAO){
        this.urgenciaDAO = urgenciaDAO;
        this.urgenciaMapper = urgenciaMapper;
    }

    public UrgenciaDTO saveUrgencia(UrgenciaDTO urgenciaDTO) throws ServiceException {
        Urgencia Urgencia = urgenciaMapper.mapToEntity(urgenciaDTO);
        return urgenciaMapper.mapToDTO(this.urgenciaDAO.saveUrgencia(Urgencia));
    }

    public void deleteUrgencia(UrgenciaDTO urgenciaDTO){
        this.urgenciaDAO.deleteUrgencia(urgenciaDTO.getId());
    }

    public UrgenciaDTO updateUrgencia(UrgenciaDTO urgenciaDTO) throws ServiceException{
        try {
            return this.urgenciaMapper.mapToDTO(this.urgenciaDAO.updateUrgencia(urgenciaMapper.mapToEntity(urgenciaDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<UrgenciaDTO> getUrgencias(){
        List<Urgencia> Urgencias = this.urgenciaDAO.getUrgencias();
        return Urgencias.stream().map(urgencia -> this.urgenciaMapper.mapToDTO(urgencia)).collect(Collectors.toList());
    }

    public UrgenciaDTO getUrgenciaById(Integer id) throws ServiceException{
        return this.urgenciaMapper.mapToDTO(this.urgenciaDAO.getUrgenciaById(id));
    }
}
