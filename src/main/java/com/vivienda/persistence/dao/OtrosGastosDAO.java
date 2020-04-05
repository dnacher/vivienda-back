package com.vivienda.persistence.dao;


import com.vivienda.persistence.model.OtrosGastos;
import com.vivienda.persistence.repository.OtrosGastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class OtrosGastosDAO {

    @Autowired
    public OtrosGastosRepository repository;

    public List<OtrosGastos> getOtrosGastos(){
        List<OtrosGastos> otrosGastos = new ArrayList<>();
        repository.findAll().forEach(otroGasto -> {
            otrosGastos.add(otroGasto);
        });
        return otrosGastos;
    }

    public OtrosGastos saveOtrosGastos(OtrosGastos otrosGastos){
        return repository.save(otrosGastos);
    }

    public OtrosGastos updateOtrosGastos(OtrosGastos otrosGastos) throws Exception{
        if(otrosGastos!=null && otrosGastos.getId()!=null){
            return repository.save(otrosGastos);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteOtrosGastos(Integer id){
        repository.deleteById(id);
    }

    public OtrosGastos getOtrosGastosById(Integer id){
        return repository.findById(id).get();
    }
}
