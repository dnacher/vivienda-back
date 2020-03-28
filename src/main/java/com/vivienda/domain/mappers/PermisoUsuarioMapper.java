package com.vivienda.domain.mappers;

import com.vivienda.api.dto.PermisoUsuarioDTO;
import com.vivienda.persistence.model.PermisoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermisoUsuarioMapper implements AbstractMapper<PermisoUsuario, PermisoUsuarioDTO>{

    @Autowired
    private TipoUsuarioMapper tipoUsuarioMapper;

    @Override
    public PermisoUsuario mapToEntity(PermisoUsuarioDTO dto) {
        PermisoUsuario permisoUsuario = new PermisoUsuario();
        permisoUsuario.setTipoUsuario(tipoUsuarioMapper.mapToEntity(dto.getTipoUsuario()));
        permisoUsuario.setPagina(dto.getPagina());
        permisoUsuario.setPermiso(dto.getPermiso());
        return permisoUsuario;
    }

    @Override
    public PermisoUsuarioDTO mapToDTO(PermisoUsuario entity) {
        PermisoUsuarioDTO permisoUsuario = new PermisoUsuarioDTO();
        permisoUsuario.setTipoUsuario(tipoUsuarioMapper.mapToDTO(entity.getTipoUsuario()));
        permisoUsuario.setPagina(entity.getPagina());
        permisoUsuario.setPermiso(entity.getPermiso());
        return permisoUsuario;
    }
}
