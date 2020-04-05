package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.ListaPrecio;
import com.vivienda.persistence.repository.ListaPrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ListaPrecioDAO {

    @Autowired
    public ListaPrecioRepository repository;

    public List<ListaPrecio> getListaPrecio(){
        List<ListaPrecio> listaPrecios = new ArrayList<>();
        repository.findAll().forEach(listaPrecio -> {
            listaPrecios.add(listaPrecio);
        });
        return listaPrecios;
    }

    public ListaPrecio saveListaPrecio(ListaPrecio listaPrecio){
        return repository.save(listaPrecio);
    }

    public ListaPrecio updateListaPrecio(ListaPrecio listaPrecio) throws Exception{
        if(listaPrecio!=null && listaPrecio.getId()!=null){
            return repository.save(listaPrecio);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteListaPrecio(Integer id){
        repository.deleteById(id);
    }

    public ListaPrecio getListaPrecioById(Integer id){
        return repository.findById(id).get();
    }
}
