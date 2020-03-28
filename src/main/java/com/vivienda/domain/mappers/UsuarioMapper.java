package com.vivienda.domain.mappers;

import com.vivienda.api.dto.UsuarioDTO;
import com.vivienda.persistence.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements AbstractMapper<Usuario, UsuarioDTO>{

    @Autowired
    private TipoUsuarioMapper tipoUsuarioMapper;

    @Override
    public Usuario mapToEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setActivo(dto.getActivo());
        usuario.setHashedPassword(dto.getHashedPassword());
        usuario.setNombre(dto.getNombre());
        usuario.setNombreTipoUsuario(dto.getNombreTipoUsuario());
        usuario.setPassword(dto.getPassword());
        usuario.setSalt(dto.getSalt());
        usuario.setTipousuario(tipoUsuarioMapper.mapToEntity(dto.getTipoUsuario()));
        return usuario;
    }

    @Override
    public UsuarioDTO mapToDTO(Usuario entity) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setId(entity.getId());
        usuario.setActivo(entity.getActivo());
        usuario.setHashedPassword(entity.getHashedPassword());
        usuario.setNombre(entity.getNombre());
        usuario.setNombreTipoUsuario(entity.getNombreTipoUsuario());
        usuario.setPassword(entity.getPassword());
        usuario.setSalt(entity.getSalt());
        usuario.setTipoUsuario(tipoUsuarioMapper.mapToDTO(entity.getTipousuario()));
        return usuario;
    }
}
