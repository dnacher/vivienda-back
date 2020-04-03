package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.TipoUsuarioDTO;
import com.vivienda.domain.service.TipoUsuarioService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/tipo_usuarios")
public class TipoUsuarioController {
    
    private TipoUsuarioService tipoUsuarioService;

    @Autowired
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService){
        this.tipoUsuarioService=tipoUsuarioService;
    }

    @PostMapping(value = "/mul")
    public List<TipoUsuarioDTO> saveTipoUsuarios(@RequestBody List<TipoUsuarioDTO> tipoUsuarioDTOS){
        List<TipoUsuarioDTO> finalList = new ArrayList<>();
        tipoUsuarioDTOS.forEach(tipoUsuarioDTO -> {
            try {
                finalList.add(this.tipoUsuarioService.saveTipoUsuario(tipoUsuarioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<TipoUsuarioDTO> updateTipoUsuario(@RequestBody List<TipoUsuarioDTO> tipoUsuarioDTOS){
        List<TipoUsuarioDTO> finalList = new ArrayList<>();
        tipoUsuarioDTOS.forEach(tipoUsuarioDTO -> {
            try {
                finalList.add(this.tipoUsuarioService.updateTipoUsuario(tipoUsuarioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public TipoUsuarioDTO saveTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) throws ServiceException {
        return this.tipoUsuarioService.saveTipoUsuario(tipoUsuarioDTO);
    }

    @PutMapping(value = "/{id}")
    public TipoUsuarioDTO updateTipoUsuario(@PathVariable Integer id, @RequestBody TipoUsuarioDTO tipoUsuarioDTO) throws ServiceException {
        String msg = String.format("The Tipo de usuario Id %s is different from the Url Id",tipoUsuarioDTO.getId());
        return this.tipoUsuarioService.saveTipoUsuario(tipoUsuarioDTO);
    }

    @GetMapping(value = "/")
    public List<TipoUsuarioDTO> getTipoUsuarios(){
        return this.tipoUsuarioService.getTipoUsuarios();
    }

    @GetMapping(value = "/{id}")
    public TipoUsuarioDTO getTipoUsuarioById(@PathVariable Integer id) throws ServiceException {
        return this.tipoUsuarioService.getTipoUsuarioById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTipoUsuario(@PathVariable Integer id, TipoUsuarioDTO tipoUsuarioDTO){
        String msg = String.format("The Tipo de usuario Id %s is different from the Url Id",tipoUsuarioDTO.getId());
        this.tipoUsuarioService.deleteTipoUsuario(tipoUsuarioDTO);
    }
}
