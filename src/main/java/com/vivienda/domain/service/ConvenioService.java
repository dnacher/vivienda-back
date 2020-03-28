package com.vivienda.domain.service;

import com.vivienda.api.dto.ConvenioDTO;
import com.vivienda.domain.mappers.ConvenioMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.ConvenioDAO;
import com.vivienda.persistence.model.Convenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConvenioService {

    private final ConvenioDAO ConvenioDAO;

    private final ConvenioMapper ConvenioMapper;


    @Autowired
    public ConvenioService(ConvenioMapper convenioMapper, ConvenioDAO convenioDAO){
        this.ConvenioDAO = convenioDAO;
        this.ConvenioMapper = convenioMapper;
    }

    public ConvenioDTO saveConvenio(ConvenioDTO convenioDTO) throws ServiceException {
        Convenio Convenio = ConvenioMapper.mapToEntity(convenioDTO);
        return ConvenioMapper.mapToDTO(this.ConvenioDAO.saveConvenio(Convenio));
    }

    public void deleteConvenio(ConvenioDTO convenioDTO){
        this.ConvenioDAO.deleteConvenio(convenioDTO.getId());
    }

    public ConvenioDTO updateConvenio(ConvenioDTO convenioDTO) throws ServiceException{
        try {
            return this.ConvenioMapper.mapToDTO(this.ConvenioDAO.updateConvenio(ConvenioMapper.mapToEntity(convenioDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<ConvenioDTO> getConvenios(){
        List<Convenio> Convenios = this.ConvenioDAO.getConvenios();
        return Convenios.stream().map(convenio -> this.ConvenioMapper.mapToDTO(convenio)).collect(Collectors.toList());
    }

    public ConvenioDTO getConvenioById(Integer id) throws ServiceException{
        return this.ConvenioMapper.mapToDTO(this.ConvenioDAO.getConvenioById(id));
    }
}
