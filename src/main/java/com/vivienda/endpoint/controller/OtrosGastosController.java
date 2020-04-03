package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.OtrosGastosDTO;
import com.vivienda.domain.service.OtrosGastosService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/otros_gastos")
public class OtrosGastosController {
    
    private final OtrosGastosService otrosGastosService;

    @Autowired
    public OtrosGastosController(OtrosGastosService otrosGastosService){
        this.otrosGastosService= otrosGastosService;
    }

    @PostMapping(value = "/mul")
    public List<OtrosGastosDTO> saveOtrosGastoss(@RequestBody List<OtrosGastosDTO> otrosGastosDTOS){
        List<OtrosGastosDTO> finalList = new ArrayList<>();
        otrosGastosDTOS.forEach(otrosGastosDTO -> {
            try {
                finalList.add(this.otrosGastosService.saveOtrosGastos(otrosGastosDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<OtrosGastosDTO> updateOtrosGastos(@RequestBody List<OtrosGastosDTO> otrosGastosDTOS){
        List<OtrosGastosDTO> finalList = new ArrayList<>();
        otrosGastosDTOS.forEach(otrosGastosDTO -> {
            try {
                finalList.add(this.otrosGastosService.updateOtrosGastos(otrosGastosDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public OtrosGastosDTO saveOtrosGastos(OtrosGastosDTO otrosGastosDTO) throws ServiceException {
        return this.otrosGastosService.saveOtrosGastos(otrosGastosDTO);
    }

    @PutMapping(value = "/{id}")
    public OtrosGastosDTO updateOtrosGastos(@PathVariable Integer id, @RequestBody OtrosGastosDTO otrosGastosDTO) throws ServiceException {
        String msg = String.format("The Otros Gastos Id %s is different from the Url Id",otrosGastosDTO.getId());
        return this.otrosGastosService.saveOtrosGastos(otrosGastosDTO);
    }

    @GetMapping(value = "/")
    public List<OtrosGastosDTO> getOtrosGastoss(){
        return this.otrosGastosService.getOtrosGastos();
    }

    @GetMapping(value = "/{id}")
    public OtrosGastosDTO getOtrosGastosById(@PathVariable Integer id) throws ServiceException {
        return this.otrosGastosService.getOtrosGastosById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOtrosGastos(@PathVariable Integer id, OtrosGastosDTO otrosGastosDTO){
        String msg = String.format("The Convenio Id %s is different from the Url Id",otrosGastosDTO.getId());
        this.otrosGastosService.deleteOtrosGastos(otrosGastosDTO);
    }
}
