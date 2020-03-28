package com.vivienda.domain.service;

import com.vivienda.api.dto.TecnicoDTO;
import com.vivienda.domain.mappers.TecnicoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.TecnicoDAO;
import com.vivienda.persistence.model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TecnicoService {

    private final TecnicoDAO TecnicoDAO;

    private final TecnicoMapper TecnicoMapper;


    @Autowired
    public TecnicoService(TecnicoMapper tecnicoMapper, TecnicoDAO tecnicoDAO){
        this.TecnicoDAO = tecnicoDAO;
        this.TecnicoMapper = tecnicoMapper;
    }

    public TecnicoDTO saveTecnico(TecnicoDTO tecnicoDTO) throws ServiceException {
        Tecnico Tecnico = TecnicoMapper.mapToEntity(tecnicoDTO);
        return TecnicoMapper.mapToDTO(this.TecnicoDAO.saveTecnico(Tecnico));
    }

    public void deleteTecnico(TecnicoDTO tecnicoDTO){
        this.TecnicoDAO.deleteTecnico(tecnicoDTO.getId());
    }

    public TecnicoDTO updateTecnico(TecnicoDTO tecnicoDTO) throws ServiceException{
        try {
            return this.TecnicoMapper.mapToDTO(this.TecnicoDAO.updateTecnico(TecnicoMapper.mapToEntity(tecnicoDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<TecnicoDTO> getTecnicos(){
        List<Tecnico> Tecnicos = this.TecnicoDAO.getTecnicos();
        return Tecnicos.stream().map(tecnico -> this.TecnicoMapper.mapToDTO(tecnico)).collect(Collectors.toList());
    }

    public TecnicoDTO getTecnicoById(Integer id) throws ServiceException{
        return this.TecnicoMapper.mapToDTO(this.TecnicoDAO.getTecnicoById(id));
    }
}
