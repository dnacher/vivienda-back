package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.Urgencia;
import com.vivienda.persistence.repository.UrgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class UrgenciaDAO {

    @Autowired
    public UrgenciaRepository repository;

    public List<Urgencia> getUrgencias(){
        List<Urgencia> urgencias = new ArrayList<>();
        repository.findAll().forEach(urgencia -> {
            urgencias.add(urgencia);
        });
        return urgencias;
    }

    public Urgencia saveUrgencia(Urgencia urgencia){
        return repository.save(urgencia);
    }

    public Urgencia updateUrgencia(Urgencia urgencia) throws Exception{
        if(urgencia!=null && urgencia.getId()!=null){
            return repository.save(urgencia);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteUrgencia(Integer id){
        repository.deleteById(id);
    }

    public Urgencia getUrgenciaById(Integer id){
        return repository.findById(id).get();
    }
}
