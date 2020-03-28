package com.vivienda.persistence.repository;

import com.vivienda.persistence.model.PermisoUsuario;
import com.vivienda.persistence.model.TipoUsuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermisoUsuarioRepository extends CrudRepository<PermisoUsuario,Integer> {

    List<PermisoUsuario> getAllByTipoUsuario(TipoUsuario tipoUsuario);
    void deleteByTipoUsuario(TipoUsuario tipoUsuario);
}
