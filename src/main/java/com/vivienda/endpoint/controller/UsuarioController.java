package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.UsuarioDTO;
import com.vivienda.domain.service.UsuarioService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @PostMapping(value = "/mul")
    public List<UsuarioDTO> saveUsuarios(@RequestBody List<UsuarioDTO> usuarioDTOS){
        List<UsuarioDTO> finalList = new ArrayList<>();
        usuarioDTOS.forEach(usuarioDTO -> {
            try {
                finalList.add(this.usuarioService.saveUsuario(usuarioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<UsuarioDTO> updateUsuario(@RequestBody List<UsuarioDTO> usuarioDTOS){
        List<UsuarioDTO> finalList = new ArrayList<>();
        usuarioDTOS.forEach(usuarioDTO -> {
            try {
                finalList.add(this.usuarioService.updateUsuario(usuarioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) throws ServiceException {
        return this.usuarioService.saveUsuario(usuarioDTO);
    }

    @PutMapping(value = "/{id}")
    public UsuarioDTO updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) throws ServiceException {
        String msg = String.format("The Usuario Id %s is different from the Url Id",usuarioDTO.getId());
        return this.usuarioService.saveUsuario(usuarioDTO);
    }

    @GetMapping(value = "/")
    public List<UsuarioDTO> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }

    @GetMapping(value = "/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Integer id) throws ServiceException {
        return this.usuarioService.getUsuarioById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsuario(@PathVariable Integer id, UsuarioDTO usuarioDTO){
        String msg = String.format("The Usuario Id %s is different from the Url Id",usuarioDTO.getId());
        this.usuarioService.deleteUsuario(usuarioDTO);
    }
}
