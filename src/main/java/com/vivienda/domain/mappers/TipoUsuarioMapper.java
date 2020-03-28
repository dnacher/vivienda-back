package com.vivienda.domain.mappers;

import com.vivienda.api.dto.TipoDuracionDTO;
import com.vivienda.api.dto.TipoUsuarioDTO;
import com.vivienda.persistence.model.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoUsuarioMapper implements AbstractMapper<TipoUsuario, TipoUsuarioDTO>{

    @Autowired
    private PermisoUsuarioMapper permisoUsuarioMapper;

    @Override
    public TipoUsuario mapToEntity(TipoUsuarioDTO dto) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setId(dto.getId());
        tipoUsuario.setNombre(dto.getNombre());
        tipoUsuario.setDescripcion(dto.getDescripcion());
        tipoUsuario.setPermisoUsuario(permisoUsuarioMapper.mapToEntity(dto.getPermisoUsuario()));
        tipoUsuario.setActivo(dto.getActivo());
        return tipoUsuario;
    }

    @Override
    public TipoUsuarioDTO mapToDTO(TipoUsuario entity) {
        TipoUsuarioDTO tipoUsuario = new TipoUsuarioDTO();
        tipoUsuario.setId(entity.getId());
        tipoUsuario.setNombre(entity.getNombre());
        tipoUsuario.setDescripcion(entity.getDescripcion());
        tipoUsuario.setPermisoUsuario(permisoUsuarioMapper.mapToDTO(entity.getPermisoUsuario()));
        tipoUsuario.setActivo(entity.getActivo());
        return tipoUsuario;
    }
}
