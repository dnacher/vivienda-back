package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.MontoDTO;
import com.vivienda.domain.service.MontoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/montos")
public class MontoController {
    
    private final MontoService montoService;

    @Autowired
    public MontoController(MontoService montoService){
        this.montoService= montoService;
    }

    @PostMapping(value = "/mul")
    public List<MontoDTO> saveMontos(@RequestBody List<MontoDTO> montoDTOS){
        List<MontoDTO> finalList = new ArrayList<>();
        montoDTOS.forEach(montoDTO -> {
            try {
                finalList.add(this.montoService.saveMonto(montoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<MontoDTO> updateMonto(@RequestBody List<MontoDTO> montoDTOS){
        List<MontoDTO> finalList = new ArrayList<>();
        montoDTOS.forEach(montoDTO -> {
            try {
                finalList.add(this.montoService.updateMonto(montoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public MontoDTO saveMonto(MontoDTO montoDTO) throws ServiceException {
        return this.montoService.saveMonto(montoDTO);
    }

    @PutMapping(value = "/{id}")
    public MontoDTO updateMonto(@PathVariable Integer id, @RequestBody MontoDTO montoDTO) throws ServiceException {
        String msg = String.format("The Monto Id %s is different from the Url Id",montoDTO.getId());
        return this.montoService.saveMonto(montoDTO);
    }

    @GetMapping(value = "/")
    public List<MontoDTO> getMontos(){
        return this.montoService.getMontos();
    }

    @GetMapping(value = "/{id}")
    public MontoDTO getMontoById(@PathVariable Integer id) throws ServiceException {
        return this.montoService.getMontoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMonto(@PathVariable Integer id, MontoDTO montoDTO){
        String msg = String.format("The Monto Id %s is different from the Url Id",montoDTO.getId());
        this.montoService.deleteMonto(montoDTO);
    }
}
