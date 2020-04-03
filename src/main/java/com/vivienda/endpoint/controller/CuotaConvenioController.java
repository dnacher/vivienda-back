package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.CuotaConvenioDTO;
import com.vivienda.domain.service.CuotaConvenioService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cuota_convenios")
public class CuotaConvenioController {

    private final CuotaConvenioService cuotaConvenioService;

    @Autowired
    public CuotaConvenioController(CuotaConvenioService cuotaConvenioService){
        this.cuotaConvenioService = cuotaConvenioService;
    }

    @PostMapping(value = "/mul")
    public List<CuotaConvenioDTO> saveCuotaConvenios(@RequestBody List<CuotaConvenioDTO> cuotaConvenioDTOS){
        List<CuotaConvenioDTO> finalList = new ArrayList<>();
        cuotaConvenioDTOS.forEach(cuotaConvenioDTO -> {
            try {
                finalList.add(this.cuotaConvenioService.saveCuotaConvenio(cuotaConvenioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<CuotaConvenioDTO> updateConvenio(@RequestBody List<CuotaConvenioDTO> cuotaConvenioDTOS){
        List<CuotaConvenioDTO> finalList = new ArrayList<>();
        cuotaConvenioDTOS.forEach(cuotaConvenioDTO -> {
            try {
                finalList.add(this.cuotaConvenioService.updateCuotaConvenio(cuotaConvenioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public CuotaConvenioDTO saveCuotaConvenio(CuotaConvenioDTO cuotaConvenioDTO) throws ServiceException {
        return this.cuotaConvenioService.saveCuotaConvenio(cuotaConvenioDTO);
    }

    @PutMapping(value = "/{id}")
    public CuotaConvenioDTO updateCuotaConvenio(@PathVariable Integer id, @RequestBody CuotaConvenioDTO cuotaConvenioDTO) throws ServiceException {
        String msg = String.format("The Cuota Convenio Id %s is different from the Url Id",cuotaConvenioDTO.getId());
        return this.cuotaConvenioService.saveCuotaConvenio(cuotaConvenioDTO);
    }

    @GetMapping(value = "/")
    public List<CuotaConvenioDTO> getCuotaConvenios(){
        return this.cuotaConvenioService.getCuotaConvenios();
    }

    @GetMapping(value = "/{id}")
    public CuotaConvenioDTO getCuotaConvenioById(@PathVariable Integer id) throws ServiceException {
        return this.cuotaConvenioService.getCuotaConvenioById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCuotaConvenio(@PathVariable Integer id, CuotaConvenioDTO cuotaConvenioDTO){
        String msg = String.format("The Convenio Id %s is different from the Url Id",cuotaConvenioDTO.getId());
        this.cuotaConvenioService.deleteCuotaConvenio(cuotaConvenioDTO);
    }

}
