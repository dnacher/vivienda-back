package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.PermisoUsuarioDTO;
import com.vivienda.domain.service.PermisoUsuarioService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/permiso_usuarios")
public class PermisoUsuarioController {

    private final PermisoUsuarioService permisoUsuarioService;

    @Autowired
    public PermisoUsuarioController(PermisoUsuarioService permisoUsuarioService){
        this.permisoUsuarioService=permisoUsuarioService;
    }

    @PostMapping(value = "/mul")
    public List<PermisoUsuarioDTO> savePermisoUsuarios(@RequestBody List<PermisoUsuarioDTO> permisoUsuarioDTOS){
        List<PermisoUsuarioDTO> finalList = new ArrayList<>();
        permisoUsuarioDTOS.forEach(permisoUsuarioDTO -> {
            try {
                finalList.add(this.permisoUsuarioService.savePermisoUsuario(permisoUsuarioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<PermisoUsuarioDTO> updatePermisoUsuario(@RequestBody List<PermisoUsuarioDTO> permisoUsuarioDTOS){
        List<PermisoUsuarioDTO> finalList = new ArrayList<>();
        permisoUsuarioDTOS.forEach(permisoUsuarioDTO -> {
            try {
                finalList.add(this.permisoUsuarioService.updatePermisoUsuario(permisoUsuarioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public PermisoUsuarioDTO savePermisoUsuario(PermisoUsuarioDTO permisoUsuarioDTO) throws ServiceException {
        return this.permisoUsuarioService.savePermisoUsuario(permisoUsuarioDTO);
    }

    @PutMapping(value = "/{id}")
    public PermisoUsuarioDTO updatePermisoUsuario(@PathVariable Integer id, @RequestBody PermisoUsuarioDTO permisoUsuarioDTO) throws ServiceException {
        String msg = String.format("The Permiso de Usuario %s is different from the Url Id",permisoUsuarioDTO.getTipoUsuario().getId());
        return this.permisoUsuarioService.savePermisoUsuario(permisoUsuarioDTO);
    }

    @GetMapping(value = "/")
    public List<PermisoUsuarioDTO> getPermisoUsuarios(){
        return this.permisoUsuarioService.getPermisoUsuarios();
    }

    @GetMapping(value = "/{id}")
    public PermisoUsuarioDTO getPermisoUsuarioById(@PathVariable Integer id) throws ServiceException {
        return this.permisoUsuarioService.getPermisoUsuarioById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePermisoUsuario(@PathVariable Integer id, PermisoUsuarioDTO permisoUsuarioDTO){
        String msg = String.format("The Permiso de Usuario Id %s is different from the Url Id",permisoUsuarioDTO);
        this.permisoUsuarioService.deletePermisoUsuario(permisoUsuarioDTO);
    }
}
