package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.HistorialMontoDTO;
import com.vivienda.domain.service.HistorialMontoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/historial_montos")
public class HistorialMontoController {

    private final HistorialMontoService historialMontoService;

    @Autowired
    public HistorialMontoController(HistorialMontoService historialMontoService){
        this.historialMontoService = historialMontoService;
    }

    @PostMapping(value = "/mul")
    public List<HistorialMontoDTO> saveHistorialMontos(@RequestBody List<HistorialMontoDTO> historialMontoDTOS){
        List<HistorialMontoDTO> finalList = new ArrayList<>();
        historialMontoDTOS.forEach(historialMontoDTO -> {
            try {
                finalList.add(this.historialMontoService.saveHistorialMonto(historialMontoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<HistorialMontoDTO> updateHistorialMonto(@RequestBody List<HistorialMontoDTO> historialMontoDTOS){
        List<HistorialMontoDTO> finalList = new ArrayList<>();
        historialMontoDTOS.forEach(historialMontoDTO -> {
            try {
                finalList.add(this.historialMontoService.updateHistorialMonto(historialMontoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public HistorialMontoDTO saveHistorialMonto(HistorialMontoDTO historialMontoDTO) throws ServiceException {
        return this.historialMontoService.saveHistorialMonto(historialMontoDTO);
    }

    @PutMapping(value = "/{id}")
    public HistorialMontoDTO updateHistorialMonto(@PathVariable Integer id, @RequestBody HistorialMontoDTO historialMontoDTO) throws ServiceException {
        String msg = String.format("The Historial Monto Id %s is different from the Url Id",historialMontoDTO.getId());
        return this.historialMontoService.saveHistorialMonto(historialMontoDTO);
    }

    @GetMapping(value = "/")
    public List<HistorialMontoDTO> getHistorialMontos(){
        return this.historialMontoService.getHistorialMontos();
    }

    @GetMapping(value = "/{id}")
    public HistorialMontoDTO getHistorialMontoById(@PathVariable Integer id) throws ServiceException {
        return this.historialMontoService.getHistorialMontoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHistorialMonto(@PathVariable Integer id, HistorialMontoDTO historialMontoDTO){
        String msg = String.format("The Convenio Id %s is different from the Url Id",historialMontoDTO.getId());
        this.historialMontoService.deleteHistorialMonto(historialMontoDTO);
    }
}
