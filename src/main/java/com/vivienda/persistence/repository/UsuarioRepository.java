package com.vivienda.persistence.repository;

import com.vivienda.persistence.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {

    Usuario getUsuarioByNombre(String nombre);

}
