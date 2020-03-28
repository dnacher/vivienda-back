package com.vivienda.domain.service;

import com.vivienda.api.dto.GrupoDTO;
import com.vivienda.domain.mappers.GrupoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.GrupoDAO;
import com.vivienda.persistence.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoService {

    private final GrupoDAO grupoDAO;

    private final GrupoMapper grupoMapper;


    @Autowired
    public GrupoService(GrupoMapper grupoMapper, GrupoDAO grupoDAO){
        this.grupoDAO = grupoDAO;
        this.grupoMapper = grupoMapper;
    }

    public GrupoDTO saveGrupo(GrupoDTO grupoDTO) throws ServiceException {
        Grupo Grupo = grupoMapper.mapToEntity(grupoDTO);
        return grupoMapper.mapToDTO(this.grupoDAO.saveGrupo(Grupo));
    }

    public void deleteGrupo(GrupoDTO grupoDTO){
        this.grupoDAO.deleteGrupo(grupoDTO.getId());
    }

    public GrupoDTO updateGrupo(GrupoDTO grupoDTO) throws ServiceException{
        try {
            return this.grupoMapper.mapToDTO(this.grupoDAO.updateGrupo(grupoMapper.mapToEntity(grupoDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<GrupoDTO> getGrupos(){
        List<Grupo> Grupos = this.grupoDAO.getGrupos();
        return Grupos.stream().map(grupo -> this.grupoMapper.mapToDTO(grupo)).collect(Collectors.toList());
    }

    public GrupoDTO getGrupoById(Integer id) throws ServiceException{
        return this.grupoMapper.mapToDTO(this.grupoDAO.getGrupoById(id));
    }
}
