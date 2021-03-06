package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.CuotaConvenio;
import com.vivienda.persistence.repository.CuotaConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class CuotaConvenioDAO {

    @Autowired
    public CuotaConvenioRepository repository;

    public List<CuotaConvenio> getCuotaConvenios(){
        List<CuotaConvenio> cuotaConvenios = new ArrayList<>();
        repository.findAll().forEach(cuotaConvenio -> {
            cuotaConvenios.add(cuotaConvenio);
        });
        return cuotaConvenios;
    }

    public CuotaConvenio saveCuotaConvenio(CuotaConvenio cuotaConvenio){
        return repository.save(cuotaConvenio);
    }

    public CuotaConvenio updateCuotaConvenio(CuotaConvenio cuotaConvenio) throws Exception{
        if(cuotaConvenio!=null && cuotaConvenio.getId()!=null){
            return repository.save(cuotaConvenio);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteCuotaConvenio(Integer id){
        repository.deleteById(id);
    }

    public CuotaConvenio getCuotaConvenioById(Integer id){
        return repository.findById(id).get();
    }
}
