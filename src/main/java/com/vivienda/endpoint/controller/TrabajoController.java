package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.TrabajoDTO;
import com.vivienda.domain.service.TrabajoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/trabajos")
public class TrabajoController {
    
    private final TrabajoService trabajoService;

    @Autowired
    public TrabajoController(TrabajoService trabajoService){
        this.trabajoService= trabajoService;
    }

    @PostMapping(value = "/mul")
    public List<TrabajoDTO> saveTrabajos(@RequestBody List<TrabajoDTO> trabajoDTOS){
        List<TrabajoDTO> finalList = new ArrayList<>();
        trabajoDTOS.forEach(trabajoDTO -> {
            try {
                finalList.add(this.trabajoService.saveTrabajo(trabajoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<TrabajoDTO> updateTrabajo(@RequestBody List<TrabajoDTO> trabajoDTOS){
        List<TrabajoDTO> finalList = new ArrayList<>();
        trabajoDTOS.forEach(trabajoDTO -> {
            try {
                finalList.add(this.trabajoService.updateTrabajo(trabajoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public TrabajoDTO saveTrabajo(TrabajoDTO trabajoDTO) throws ServiceException {
        return this.trabajoService.saveTrabajo(trabajoDTO);
    }

    @PutMapping(value = "/{id}")
    public TrabajoDTO updateTrabajo(@PathVariable Integer id, @RequestBody TrabajoDTO trabajoDTO) throws ServiceException {
        String msg = String.format("The Cuota Convenio Id %s is different from the Url Id",trabajoDTO.getId());
        return this.trabajoService.saveTrabajo(trabajoDTO);
    }

    @GetMapping(value = "/")
    public List<TrabajoDTO> getTrabajos(){
        return this.trabajoService.getTrabajos();
    }

    @GetMapping(value = "/{id}")
    public TrabajoDTO getTrabajoById(@PathVariable Integer id) throws ServiceException {
        return this.trabajoService.getTrabajoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTrabajo(@PathVariable Integer id, TrabajoDTO TrabajoDTO){
        String msg = String.format("The Convenio Id %s is different from the Url Id",TrabajoDTO.getId());
        this.trabajoService.deleteTrabajo(TrabajoDTO);
    }
}
