package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.TipoDuracionDTO;
import com.vivienda.domain.service.TipoDuracionService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/tipo_duraciones")
public class TipoDuracionController {
    
    private final TipoDuracionService tipoDuracionService;

    @Autowired
    public TipoDuracionController(TipoDuracionService tipoDuracionService){
        this.tipoDuracionService=tipoDuracionService;
    }

    @PostMapping(value = "/mul")
    public List<TipoDuracionDTO> saveTipoDuracions(@RequestBody List<TipoDuracionDTO> tipoDuracionDTOS){
        List<TipoDuracionDTO> finalList = new ArrayList<>();
        tipoDuracionDTOS.forEach(tipoDuracionDTO -> {
            try {
                finalList.add(this.tipoDuracionService.saveTipoDuracion(tipoDuracionDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<TipoDuracionDTO> updateTipoDuracion(@RequestBody List<TipoDuracionDTO> tipoDuracionDTOS){
        List<TipoDuracionDTO> finalList = new ArrayList<>();
        tipoDuracionDTOS.forEach(tipoDuracionDTO -> {
            try {
                finalList.add(this.tipoDuracionService.updateTipoDuracion(tipoDuracionDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public TipoDuracionDTO saveTipoDuracion(TipoDuracionDTO tipoDuracionDTO) throws ServiceException {
        return this.tipoDuracionService.saveTipoDuracion(tipoDuracionDTO);
    }

    @PutMapping(value = "/{id}")
    public TipoDuracionDTO updateTipoDuracion(@PathVariable Integer id, @RequestBody TipoDuracionDTO tipoDuracionDTO) throws ServiceException {
        String msg = String.format("The Tipo de duracion Id %s is different from the Url Id",tipoDuracionDTO.getId());
        return this.tipoDuracionService.saveTipoDuracion(tipoDuracionDTO);
    }

    @GetMapping(value = "/")
    public List<TipoDuracionDTO> getTipoDuraciones(){
        return this.tipoDuracionService.getTipoDuraciones();
    }

    @GetMapping(value = "/{id}")
    public TipoDuracionDTO getTipoDuracionById(@PathVariable Integer id) throws ServiceException {
        return this.tipoDuracionService.getTipoDuracionById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTipoDuracion(@PathVariable Integer id, TipoDuracionDTO tipoDuracionDTO){
        String msg = String.format("The Tipo de duracion Id %s is different from the Url Id",tipoDuracionDTO.getId());
        this.tipoDuracionService.deleteTipoDuracion(tipoDuracionDTO);
    }
}
