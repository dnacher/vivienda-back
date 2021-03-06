package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.HistorialTrabajo;
import com.vivienda.persistence.repository.HistorialTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class HistorialTrabajoDAO {

    @Autowired
    public HistorialTrabajoRepository repository;

    public List<HistorialTrabajo> getHistorialTrabajos(){
        List<HistorialTrabajo> historialTrabajos = new ArrayList<>();
        repository.findAll().forEach(historialTrabajo -> {
            historialTrabajos.add(historialTrabajo);
        });
        return historialTrabajos;
    }

    public HistorialTrabajo saveHistorialTrabajo(HistorialTrabajo historialTrabajo){
        return repository.save(historialTrabajo);
    }

    public HistorialTrabajo updateHistorialTrabajo(HistorialTrabajo historialTrabajo) throws Exception{
        if(historialTrabajo!=null && historialTrabajo.getId()!=null){
            return repository.save(historialTrabajo);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteHistorialTrabajo(Integer id){
        repository.deleteById(id);
    }

    public HistorialTrabajo getHistorialTrabajoById(Integer id){
        return repository.findById(id).get();
    }
}
