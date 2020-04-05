package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.TipoUsuario;
import com.vivienda.persistence.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class TipoUsuarioDAO {

    @Autowired
    public TipoUsuarioRepository repository;

    public List<TipoUsuario> getTipoUsuarios(){
        List<TipoUsuario> tipoUsuarios = new ArrayList<>();
        repository.findAll().forEach(tipoUsuario -> {
            tipoUsuarios.add(tipoUsuario);
        });
        return tipoUsuarios;
    }

    public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario){
        return repository.save(tipoUsuario);
    }

    public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario) throws Exception{
        if(tipoUsuario!=null && tipoUsuario.getId()!=null){
            return repository.save(tipoUsuario);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteTipoUsuario(Integer id){
        repository.deleteById(id);
    }

    public TipoUsuario getTipoUsuarioById(Integer id){
        return repository.findById(id).get();
    }
}
