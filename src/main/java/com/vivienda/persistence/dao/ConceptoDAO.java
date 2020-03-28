package com.vivienda.persistence.dao;

import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.model.Concepto;
import com.vivienda.persistence.repository.ConceptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ConceptoDAO {

    @Autowired
    public ConceptoRepository repository;

    public List<Concepto> getConceptos(){
        List<Concepto> conceptos = new ArrayList<>();
        repository.findAll().forEach(concepto -> {
            conceptos.add(concepto);
        });
        return conceptos;
    }

    public Concepto saveConcepto(Concepto concepto){
        return repository.save(concepto);
    }

    public Concepto updateConcepto(Concepto concepto) throws ServiceException {
        if(concepto!=null && concepto.getId()!=null){
            return repository.save(concepto);
        }else{
            throw new ServiceException("el id no puede estar vacio");
        }
    }

    public void deleteConcepto(Integer conceptoId){
        repository.deleteById(conceptoId);
    }

    public Concepto getConceptoById(Integer conceptoId){
        return repository.findById(conceptoId).get();
    }
}
