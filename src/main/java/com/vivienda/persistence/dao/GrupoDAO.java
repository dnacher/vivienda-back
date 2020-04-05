package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.Grupo;
import com.vivienda.persistence.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class GrupoDAO {

    @Autowired
    public GrupoRepository repository;

    public List<Grupo> getGrupos(){
        List<Grupo> grupos = new ArrayList<>();
        repository.findAll().forEach(grupo -> {
            grupos.add(grupo);
        });
        return grupos;
    }

    public Grupo saveGrupo(Grupo grupo){
        return repository.save(grupo);
    }

    public Grupo updateGrupo(Grupo grupo) throws Exception{
        if(grupo!=null && grupo.getId()!=null){
            return repository.save(grupo);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteGrupo(Integer id){
        repository.deleteById(id);
    }

    public Grupo getGrupoById(Integer id){
        return repository.findById(id).get();
    }
}
