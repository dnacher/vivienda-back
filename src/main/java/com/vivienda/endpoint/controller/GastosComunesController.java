package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.GastosComunesDTO;
import com.vivienda.domain.service.GastosComunesService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/gastos_comunes")
public class GastosComunesController {
    
    private final GastosComunesService gastosComunesService;

    @Autowired
    public GastosComunesController(GastosComunesService gastosComunesService){
        this.gastosComunesService = gastosComunesService;
    }
    
    @PostMapping(value = "/mul")
    public List<GastosComunesDTO> saveGastosComuness(@RequestBody List<GastosComunesDTO> gastosComunesDTOS){
        List<GastosComunesDTO> finalList = new ArrayList<>();
        gastosComunesDTOS.forEach(gastosComunesDTO -> {
            try {
                finalList.add(this.gastosComunesService.saveGastosComunes(gastosComunesDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<GastosComunesDTO> updateGastosComunes(@RequestBody List<GastosComunesDTO> gastosComunesDTOS){
        List<GastosComunesDTO> finalList = new ArrayList<>();
        gastosComunesDTOS.forEach(gastosComunesDTO -> {
            try {
                finalList.add(this.gastosComunesService.updateGastosComunes(gastosComunesDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public GastosComunesDTO saveGastosComunes(GastosComunesDTO gastosComunesDTO) throws ServiceException {
        return this.gastosComunesService.saveGastosComunes(gastosComunesDTO);
    }

    @PutMapping(value = "/{id}")
    public GastosComunesDTO updateGastosComunes(@PathVariable Integer id, @RequestBody GastosComunesDTO gastosComunesDTO) throws ServiceException {
        String msg = String.format("The Gastos Comunes Id %s is different from the Url Id",gastosComunesDTO.getId());
        return this.gastosComunesService.saveGastosComunes(gastosComunesDTO);
    }

    @GetMapping(value = "/")
    public List<GastosComunesDTO> getGastosComuness(){
        return this.gastosComunesService.getGastosComuness();
    }

    @GetMapping(value = "/{id}")
    public GastosComunesDTO getGastosComunesById(@PathVariable Integer id) throws ServiceException {
        return this.gastosComunesService.getGastosComunesById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGastosComunes(@PathVariable Integer id, GastosComunesDTO gastosComunesDTO){
        String msg = String.format("The Gastos Comunes Id %s is different from the Url Id",gastosComunesDTO.getId());
        this.gastosComunesService.deleteGastosComunes(gastosComunesDTO);
    }
}
