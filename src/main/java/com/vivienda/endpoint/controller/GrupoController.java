package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.GrupoDTO;
import com.vivienda.domain.service.GrupoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    @Autowired
    public GrupoController(GrupoService grupoService){
        this.grupoService = grupoService;
    }

    @PostMapping(value = "/mul")
    public List<GrupoDTO> saveGrupos(@RequestBody List<GrupoDTO> grupoDTOS){
        List<GrupoDTO> finalList = new ArrayList<>();
        grupoDTOS.forEach(grupoDTO -> {
            try {
                finalList.add(this.grupoService.saveGrupo(grupoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<GrupoDTO> updateGrupo(@RequestBody List<GrupoDTO> grupoDTOS){
        List<GrupoDTO> finalList = new ArrayList<>();
        grupoDTOS.forEach(GrupoDTO -> {
            try {
                finalList.add(this.grupoService.updateGrupo(GrupoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public GrupoDTO saveGrupo(GrupoDTO grupoDTO) throws ServiceException {
        return this.grupoService.saveGrupo(grupoDTO);
    }

    @PutMapping(value = "/{id}")
    public GrupoDTO updateGrupo(@PathVariable Integer id, @RequestBody GrupoDTO grupoDTO) throws ServiceException {
        String msg = String.format("The Grupo Id %s is different from the Url Id",grupoDTO.getId());
        return this.grupoService.saveGrupo(grupoDTO);
    }

    @GetMapping(value = "/")
    public List<GrupoDTO> getGrupos(){
        return this.grupoService.getGrupos();
    }

    @GetMapping(value = "/{id}")
    public GrupoDTO getGrupoById(@PathVariable Integer id) throws ServiceException {
        return this.grupoService.getGrupoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGrupo(@PathVariable Integer id, GrupoDTO grupoDTO){
        String msg = String.format("The Grupo Id %s is different from the Url Id",grupoDTO.getId());
        this.grupoService.deleteGrupo(grupoDTO);
    }
}
