package com.vivienda.domain.service;

import com.vivienda.api.dto.TipoUsuarioDTO;
import com.vivienda.domain.mappers.TipoUsuarioMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.TipoUsuarioDAO;
import com.vivienda.persistence.model.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioDAO tipoUsuarioDAO;

    private final TipoUsuarioMapper tipoUsuarioMapper;


    @Autowired
    public TipoUsuarioService(TipoUsuarioMapper tipoUsuarioMapper, TipoUsuarioDAO tipoUsuarioDAO){
        this.tipoUsuarioDAO = tipoUsuarioDAO;
        this.tipoUsuarioMapper = tipoUsuarioMapper;
    }

    public TipoUsuarioDTO saveTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) throws ServiceException {
        TipoUsuario TipoUsuario = tipoUsuarioMapper.mapToEntity(tipoUsuarioDTO);
        return tipoUsuarioMapper.mapToDTO(this.tipoUsuarioDAO.saveTipoUsuario(TipoUsuario));
    }

    public void deleteTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO){
        this.tipoUsuarioDAO.deleteTipoUsuario(tipoUsuarioDTO.getId());
    }

    public TipoUsuarioDTO updateTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) throws ServiceException{
        try {
            return this.tipoUsuarioMapper.mapToDTO(this.tipoUsuarioDAO.updateTipoUsuario(tipoUsuarioMapper.mapToEntity(tipoUsuarioDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<TipoUsuarioDTO> getTipoUsuarios(){
        List<TipoUsuario> TipoUsuarios = this.tipoUsuarioDAO.getTipoUsuarios();
        return TipoUsuarios.stream().map(tipoUsuario -> this.tipoUsuarioMapper.mapToDTO(tipoUsuario)).collect(Collectors.toList());
    }

    public TipoUsuarioDTO getTipoUsuarioById(Integer id) throws ServiceException{
        return this.tipoUsuarioMapper.mapToDTO(this.tipoUsuarioDAO.getTipoUsuarioById(id));
    }
}
