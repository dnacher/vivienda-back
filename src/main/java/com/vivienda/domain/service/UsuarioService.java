package com.vivienda.domain.service;

import com.vivienda.api.dto.UsuarioDTO;
import com.vivienda.domain.mappers.UsuarioMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.UsuarioDAO;
import com.vivienda.persistence.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    private final UsuarioMapper usuarioMapper;


    @Autowired
    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) throws ServiceException {
        Usuario Usuario = usuarioMapper.mapToEntity(usuarioDTO);
        return usuarioMapper.mapToDTO(this.usuarioDAO.saveUsuario(Usuario));
    }

    public void deleteUsuario(UsuarioDTO usuarioDTO){
        this.usuarioDAO.deleteUsuario(usuarioDTO.getId());
    }

    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) throws ServiceException{
        try {
            return this.usuarioMapper.mapToDTO(this.usuarioDAO.updateUsuario(usuarioMapper.mapToEntity(usuarioDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<UsuarioDTO> getUsuarios(){
        List<Usuario> Usuarios = this.usuarioDAO.getUsuarios();
        return Usuarios.stream().map(usuario -> this.usuarioMapper.mapToDTO(usuario)).collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Integer id) throws ServiceException{
        return this.usuarioMapper.mapToDTO(this.usuarioDAO.getUsuarioById(id));
    }
}
