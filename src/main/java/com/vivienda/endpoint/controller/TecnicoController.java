package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.TecnicoDTO;
import com.vivienda.domain.service.TecnicoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {
    
    private final TecnicoService tecnicoService;

    @Autowired
    public TecnicoController(TecnicoService tecnicoService){
        this.tecnicoService=tecnicoService;
    }

    @PostMapping(value = "/mul")
    public List<TecnicoDTO> saveTecnicos(@RequestBody List<TecnicoDTO> tecnicoDTOS){
        List<TecnicoDTO> finalList = new ArrayList<>();
        tecnicoDTOS.forEach(tecnicoDTO -> {
            try {
                finalList.add(this.tecnicoService.saveTecnico(tecnicoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<TecnicoDTO> updateTecnico(@RequestBody List<TecnicoDTO> tecnicoDTOS){
        List<TecnicoDTO> finalList = new ArrayList<>();
        tecnicoDTOS.forEach(tecnicoDTO -> {
            try {
                finalList.add(this.tecnicoService.updateTecnico(tecnicoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public TecnicoDTO saveTecnico(TecnicoDTO tecnicoDTO) throws ServiceException {
        return this.tecnicoService.saveTecnico(tecnicoDTO);
    }

    @PutMapping(value = "/{id}")
    public TecnicoDTO updateTecnico(@PathVariable Integer id, @RequestBody TecnicoDTO tecnicoDTO) throws ServiceException {
        String msg = String.format("The Tecnico Id %s is different from the Url Id",tecnicoDTO.getId());
        return this.tecnicoService.saveTecnico(tecnicoDTO);
    }

    @GetMapping(value = "/")
    public List<TecnicoDTO> getTecnicos(){
        return this.tecnicoService.getTecnicos();
    }

    @GetMapping(value = "/{id}")
    public TecnicoDTO getTecnicoById(@PathVariable Integer id) throws ServiceException {
        return this.tecnicoService.getTecnicoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTecnico(@PathVariable Integer id, TecnicoDTO tecnicoDTO){
        String msg = String.format("The Tecnico Id %s is different from the Url Id",tecnicoDTO.getId());
        this.tecnicoService.deleteTecnico(tecnicoDTO);
    }
}
