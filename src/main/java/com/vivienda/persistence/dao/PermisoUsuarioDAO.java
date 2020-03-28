package com.vivienda.persistence.dao;


import com.vivienda.persistence.model.PermisoUsuario;
import com.vivienda.persistence.model.TipoUsuario;
import com.vivienda.persistence.repository.PermisoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermisoUsuarioDAO {

    @Autowired
    public PermisoUsuarioRepository repository;

    public List<PermisoUsuario> getPermisoUsuarios(){
        List<PermisoUsuario> permisoUsuarios = new ArrayList<>();
        repository.findAll().forEach(permisoUsuario -> {
            permisoUsuarios.add(permisoUsuario);
        });
        return permisoUsuarios;
    }

    public List<PermisoUsuario> getAllByTipoUsuario(TipoUsuario tipoUsuario){
        return repository.getAllByTipoUsuario(tipoUsuario);
    }

    public PermisoUsuario savePermisoUsuario(PermisoUsuario permisoUsuario){
        return repository.save(permisoUsuario);
    }

    public PermisoUsuario updatePermisoUsuario(PermisoUsuario permisoUsuario) throws Exception{
        if(permisoUsuario!=null){
            return repository.save(permisoUsuario);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deletePermisoUsuario(Integer id){
        repository.deleteById(id);
    }

    public void deletePermisoUsuarioByTipoUsuario(TipoUsuario tipoUsuario){
        repository.deleteByTipoUsuario(tipoUsuario);
    }

    public PermisoUsuario getPermisoUsuarioById(Integer id){
        return repository.findById(id).get();
    }
}
