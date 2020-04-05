package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.Convenio;
import com.vivienda.persistence.repository.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ConvenioDAO {

    @Autowired
    public ConvenioRepository repository;

    public List<Convenio> getConvenios(){
        List<Convenio> convenios = new ArrayList<>();
        repository.findAll().forEach(convenio -> {
            convenios.add(convenio);
        });
        return convenios;
    }

    public Convenio saveConvenio(Convenio convenio){
        return repository.save(convenio);
    }

    public Convenio updateConvenio(Convenio convenio) throws Exception{
        if(convenio!=null && convenio.getId()!=null){
            return repository.save(convenio);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteConvenio(Integer id){
        repository.deleteById(id);
    }

    public Convenio getConvenioById(Integer id){
        return repository.findById(id).get();
    }
}
