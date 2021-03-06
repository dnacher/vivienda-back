package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.Trabajo;
import com.vivienda.persistence.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class TrabajoDAO {

    @Autowired
    public TrabajoRepository repository;

    public List<Trabajo> getTrabajos(){
        List<Trabajo> trabajos = new ArrayList<>();
        repository.findAll().forEach(trabajo -> {
            trabajos.add(trabajo);
        });
        return trabajos;
    }

    public Trabajo saveTrabajo(Trabajo trabajo){
        return repository.save(trabajo);
    }

    public Trabajo updateTrabajo(Trabajo trabajo) throws Exception{
        if(trabajo!=null && trabajo.getId()!=null){
            return repository.save(trabajo);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteTrabajo(Integer id){
        repository.deleteById(id);
    }

    public Trabajo getTrabajoById(Integer id){
        return repository.findById(id).get();
    }
}
