package com.vivienda.persistence.dao;


import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.model.Tecnico;
import com.vivienda.persistence.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class TecnicoDAO {

    @Autowired
    public TecnicoRepository repository;

    public List<Tecnico> getTecnicos(){
        List<Tecnico> tecnicos = new ArrayList<>();
        repository.findAll().forEach(tecnico -> {
            tecnicos.add(tecnico);
        });
        return tecnicos;
    }

    public Tecnico saveTecnico(Tecnico tecnico){
        return repository.save(tecnico);
    }

    public Tecnico updateTecnico(Tecnico tecnico) throws ServiceException {
        if(tecnico!=null && tecnico.getId()!=null){
            return repository.save(tecnico);
        }else{
            throw new ServiceException("el id no puede estar vacio");
        }
    }

    public void deleteTecnico(Integer id){
        repository.deleteById(id);
    }

    public Tecnico getTecnicoById(Integer id){
        return repository.findById(id).get();
    }
}
