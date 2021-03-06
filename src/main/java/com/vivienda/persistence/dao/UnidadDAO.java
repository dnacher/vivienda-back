package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.Unidad;
import com.vivienda.persistence.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class UnidadDAO {

    @Autowired
    public UnidadRepository repository;

    public List<Unidad> getUnidades(){
        List<Unidad> unidades = new ArrayList<>();
        repository.findAll().forEach(unidad -> {
            unidades.add(unidad);
        });
        return unidades;
    }

    public Unidad saveUnidad(Unidad unidad){
        return repository.save(unidad);
    }

    public Unidad updateUnidad(Unidad unidad) throws Exception{
        if(unidad!=null && unidad.getId()!=null){
            return repository.save(unidad);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteUnidad(Integer id){
        repository.deleteById(id);
    }

    public Unidad getUnidadById(Integer id){
        return repository.findById(id).get();
    }
}
