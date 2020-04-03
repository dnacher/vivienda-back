package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.UnidadDTO;
import com.vivienda.domain.service.UnidadService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/unidades")
public class UnidadController {

    private final UnidadService unidadService;

    @Autowired
    public UnidadController(UnidadService unidadService){
        this.unidadService=unidadService;
    }

    @PostMapping(value = "/mul")
    public List<UnidadDTO> saveUnidads(@RequestBody List<UnidadDTO> unidadDTOS){
        List<UnidadDTO> finalList = new ArrayList<>();
        unidadDTOS.forEach(unidadDTO -> {
            try {
                finalList.add(this.unidadService.saveUnidad(unidadDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<UnidadDTO> updateConvenio(@RequestBody List<UnidadDTO> unidadDTOS){
        List<UnidadDTO> finalList = new ArrayList<>();
        unidadDTOS.forEach(unidadDTO -> {
            try {
                finalList.add(this.unidadService.updateUnidad(unidadDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public UnidadDTO saveUnidad(UnidadDTO unidadDTO) throws ServiceException {
        return this.unidadService.saveUnidad(unidadDTO);
    }

    @PutMapping(value = "/{id}")
    public UnidadDTO updateUnidad(@PathVariable Integer id, @RequestBody UnidadDTO unidadDTO) throws ServiceException {
        String msg = String.format("The Unidad Id %s is different from the Url Id",unidadDTO.getId());
        return this.unidadService.saveUnidad(unidadDTO);
    }

    @GetMapping(value = "/")
    public List<UnidadDTO> getUnidades(){
        return this.unidadService.getUnidades();
    }

    @GetMapping(value = "/{id}")
    public UnidadDTO getUnidadById(@PathVariable Integer id) throws ServiceException {
        return this.unidadService.getUnidadById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUnidad(@PathVariable Integer id, UnidadDTO unidadDTO){
        String msg = String.format("The Convenio Id %s is different from the Url Id",unidadDTO.getId());
        this.unidadService.deleteUnidad(unidadDTO);
    }
}
