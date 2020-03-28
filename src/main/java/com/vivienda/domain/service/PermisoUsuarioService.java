package com.vivienda.domain.service;

import com.vivienda.api.dto.PermisoUsuarioDTO;
import com.vivienda.domain.mappers.PermisoUsuarioMapper;
import com.vivienda.domain.mappers.TipoUsuarioMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.PermisoUsuarioDAO;
import com.vivienda.persistence.model.PermisoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermisoUsuarioService {

    private final PermisoUsuarioDAO PermisoUsuarioDAO;

    private final PermisoUsuarioMapper PermisoUsuarioMapper;

    @Autowired
    private TipoUsuarioMapper tipoUsuarioMapper;


    @Autowired
    public PermisoUsuarioService(PermisoUsuarioMapper permisoUsuarioMapper, PermisoUsuarioDAO permisoUsuarioDAO){
        this.PermisoUsuarioDAO = permisoUsuarioDAO;
        this.PermisoUsuarioMapper = permisoUsuarioMapper;
    }

    public PermisoUsuarioDTO savePermisoUsuario(PermisoUsuarioDTO permisoUsuarioDTO) throws ServiceException {
        PermisoUsuario PermisoUsuario = PermisoUsuarioMapper.mapToEntity(permisoUsuarioDTO);
        return PermisoUsuarioMapper.mapToDTO(this.PermisoUsuarioDAO.savePermisoUsuario(PermisoUsuario));
    }

    public void deletePermisoUsuario(PermisoUsuarioDTO permisoUsuarioDTO){
        this.PermisoUsuarioDAO.deletePermisoUsuarioByTipoUsuario(tipoUsuarioMapper.mapToEntity(permisoUsuarioDTO.getTipoUsuario()));
    }

    public PermisoUsuarioDTO updatePermisoUsuario(PermisoUsuarioDTO permisoUsuarioDTO) throws ServiceException{
        try {
            return this.PermisoUsuarioMapper.mapToDTO(this.PermisoUsuarioDAO.updatePermisoUsuario(PermisoUsuarioMapper.mapToEntity(permisoUsuarioDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<PermisoUsuarioDTO> getPermisoUsuarios(){
        List<PermisoUsuario> PermisoUsuarios = this.PermisoUsuarioDAO.getPermisoUsuarios();
        return PermisoUsuarios.stream().map(permisoUsuario -> this.PermisoUsuarioMapper.mapToDTO(permisoUsuario)).collect(Collectors.toList());
    }

    public PermisoUsuarioDTO getPermisoUsuarioById(Integer id) throws ServiceException{
        return this.PermisoUsuarioMapper.mapToDTO(this.PermisoUsuarioDAO.getPermisoUsuarioById(id));
    }
}
