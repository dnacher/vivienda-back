package com.vivienda.persistence.dao;


import com.vivienda.persistence.model.Material;
import com.vivienda.persistence.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MaterialDAO {

    @Autowired
    public MaterialRepository repository;

    public List<Material> getMateriales(){
        List<Material> materiales = new ArrayList<>();
        repository.findAll().forEach(material -> {
            materiales.add(material);
        });
        return materiales;
    }

    public Material saveMaterial(Material material){
        return repository.save(material);
    }

    public Material updateMaterial(Material material) throws Exception{
        if(material!=null && material.getId()!=null){
            return repository.save(material);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteMaterial(Integer id){
        repository.deleteById(id);
    }

    public Material getMaterialById(Integer id){
        return repository.findById(id).get();
    }
}
