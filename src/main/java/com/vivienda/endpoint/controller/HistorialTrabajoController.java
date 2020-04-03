package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.HistorialTrabajoDTO;
import com.vivienda.domain.service.HistorialTrabajoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/historial_trabajos")
public class HistorialTrabajoController {
    
    private final HistorialTrabajoService historialTrabajoService;

    @Autowired
    public HistorialTrabajoController(HistorialTrabajoService historialTrabajoService){
        this.historialTrabajoService = historialTrabajoService;
    }

    @PostMapping(value = "/mul")
    public List<HistorialTrabajoDTO> saveHistorialTrabajos(@RequestBody List<HistorialTrabajoDTO> historialTrabajoDTOS){
        List<HistorialTrabajoDTO> finalList = new ArrayList<>();
        historialTrabajoDTOS.forEach(historialTrabajoDTO -> {
            try {
                finalList.add(this.historialTrabajoService.saveHistorialTrabajo(historialTrabajoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<HistorialTrabajoDTO> updateHistorialTrabajo(@RequestBody List<HistorialTrabajoDTO> historialTrabajoDTOS){
        List<HistorialTrabajoDTO> finalList = new ArrayList<>();
        historialTrabajoDTOS.forEach(historialTrabajoDTO -> {
            try {
                finalList.add(this.historialTrabajoService.updateHistorialTrabajo(historialTrabajoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public HistorialTrabajoDTO saveHistorialTrabajo(HistorialTrabajoDTO historialTrabajoDTO) throws ServiceException {
        return this.historialTrabajoService.saveHistorialTrabajo(historialTrabajoDTO);
    }

    @PutMapping(value = "/{id}")
    public HistorialTrabajoDTO updateHistorialTrabajo(@PathVariable Integer id, @RequestBody HistorialTrabajoDTO historialTrabajoDTO) throws ServiceException {
        String msg = String.format("The Historial Trabajo Id %s is different from the Url Id",historialTrabajoDTO.getId());
        return this.historialTrabajoService.saveHistorialTrabajo(historialTrabajoDTO);
    }

    @GetMapping(value = "/")
    public List<HistorialTrabajoDTO> getHistorialTrabajos(){
        return this.historialTrabajoService.getHistorialTrabajo();
    }

    @GetMapping(value = "/{id}")
    public HistorialTrabajoDTO getHistorialTrabajoById(@PathVariable Integer id) throws ServiceException {
        return this.historialTrabajoService.getHistorialTrabajoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHistorialTrabajo(@PathVariable Integer id, HistorialTrabajoDTO historialTrabajoDTO){
        String msg = String.format("The Historial Trabajo Id %s is different from the Url Id",historialTrabajoDTO.getId());
        this.historialTrabajoService.deleteHistorialTrabajo(historialTrabajoDTO);
    }
}
