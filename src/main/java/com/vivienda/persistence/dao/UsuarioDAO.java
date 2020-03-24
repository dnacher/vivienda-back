package com.vivienda.persistence.dao;

import com.vivienda.persistence.model.Usuario;
import com.vivienda.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioDAO {

    @Autowired
    public UsuarioRepository repository;

    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        repository.findAll().forEach(usuario -> {
            usuarios.add(usuario);
        });
        return usuarios;
    }

    public Usuario getUsuarioByNombre(String nombre){
        return repository.getUsuarioByNombre(nombre);
    }

    public Usuario saveUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario updatUsuario(Usuario usuario) throws Exception{
        if(usuario!=null && usuario.getId()!=null){
            return repository.save(usuario);
        }else{
            throw new Exception("el id no puede estar vacio");
        }
    }

    public void deleteUsuario(Integer id){
        repository.deleteById(id);
    }

    public Usuario getUsuarioById(Integer id){
        return repository.findById(id).get();
    }
}
