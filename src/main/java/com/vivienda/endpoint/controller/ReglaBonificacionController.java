package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.ReglaBonificacionDTO;
import com.vivienda.domain.service.ReglaBonificacionService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/regla_bonificaciones")
public class ReglaBonificacionController {
    
    private final ReglaBonificacionService reglaBonificacionService;

    @Autowired
    public ReglaBonificacionController(ReglaBonificacionService reglaBonificacionService){
        this.reglaBonificacionService=reglaBonificacionService;
    }

    @PostMapping(value = "/mul")
    public List<ReglaBonificacionDTO> saveReglaBonificacions(@RequestBody List<ReglaBonificacionDTO> reglaBonificacionDTOS){
        List<ReglaBonificacionDTO> finalList = new ArrayList<>();
        reglaBonificacionDTOS.forEach(reglaBonificacionDTO -> {
            try {
                finalList.add(this.reglaBonificacionService.saveReglaBonificacion(reglaBonificacionDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<ReglaBonificacionDTO> updateReglaBonificacion(@RequestBody List<ReglaBonificacionDTO> reglaBonificacionDTOS){
        List<ReglaBonificacionDTO> finalList = new ArrayList<>();
        reglaBonificacionDTOS.forEach(reglaBonificacionDTO -> {
            try {
                finalList.add(this.reglaBonificacionService.updateReglaBonificacion(reglaBonificacionDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public ReglaBonificacionDTO saveReglaBonificacion(ReglaBonificacionDTO reglaBonificacionDTO) throws ServiceException {
        return this.reglaBonificacionService.saveReglaBonificacion(reglaBonificacionDTO);
    }

    @PutMapping(value = "/{id}")
    public ReglaBonificacionDTO updateReglaBonificacion(@PathVariable Integer id, @RequestBody ReglaBonificacionDTO reglaBonificacionDTO) throws ServiceException {
        String msg = String.format("The Regla Bonificacion Id %s is different from the Url Id",reglaBonificacionDTO.getId());
        return this.reglaBonificacionService.saveReglaBonificacion(reglaBonificacionDTO);
    }

    @GetMapping(value = "/")
    public List<ReglaBonificacionDTO> getReglaBonificacions(){
        return this.reglaBonificacionService.getReglaBonificacions();
    }

    @GetMapping(value = "/{id}")
    public ReglaBonificacionDTO getReglaBonificacionById(@PathVariable Integer id) throws ServiceException {
        return this.reglaBonificacionService.getReglaBonificacionById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteReglaBonificacion(@PathVariable Integer id, ReglaBonificacionDTO reglaBonificacionDTO){
        String msg = String.format("The Regla Bonificacion Id %s is different from the Url Id",reglaBonificacionDTO.getId());
        this.reglaBonificacionService.deleteReglaBonificacion(reglaBonificacionDTO);
    }
}
