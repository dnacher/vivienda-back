package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.UrgenciaDTO;
import com.vivienda.domain.service.UrgenciaService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/urgencias")
public class UrgenciaController {
    
    private final UrgenciaService urgenciaService;

    @Autowired
    public UrgenciaController(UrgenciaService urgenciaService){
        this.urgenciaService=urgenciaService;
    }

    @PostMapping(value = "/mul")
    public List<UrgenciaDTO> saveUrgencias(@RequestBody List<UrgenciaDTO> urgenciaDTOS){
        List<UrgenciaDTO> finalList = new ArrayList<>();
        urgenciaDTOS.forEach(urgenciaDTO -> {
            try {
                finalList.add(this.urgenciaService.saveUrgencia(urgenciaDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<UrgenciaDTO> updateUrgencia(@RequestBody List<UrgenciaDTO> urgenciaDTOS){
        List<UrgenciaDTO> finalList = new ArrayList<>();
        urgenciaDTOS.forEach(urgenciaDTO -> {
            try {
                finalList.add(this.urgenciaService.updateUrgencia(urgenciaDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public UrgenciaDTO saveUrgencia(UrgenciaDTO urgenciaDTO) throws ServiceException {
        return this.urgenciaService.saveUrgencia(urgenciaDTO);
    }

    @PutMapping(value = "/{id}")
    public UrgenciaDTO updateUrgencia(@PathVariable Integer id, @RequestBody UrgenciaDTO urgenciaDTO) throws ServiceException {
        String msg = String.format("The Urgencia Id %s is different from the Url Id",urgenciaDTO.getId());
        return this.urgenciaService.saveUrgencia(urgenciaDTO);
    }

    @GetMapping(value = "/")
    public List<UrgenciaDTO> getUrgencias(){
        return this.urgenciaService.getUrgencias();
    }

    @GetMapping(value = "/{id}")
    public UrgenciaDTO getUrgenciaById(@PathVariable Integer id) throws ServiceException {
        return this.urgenciaService.getUrgenciaById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUrgencia(@PathVariable Integer id, UrgenciaDTO urgenciaDTO){
        String msg = String.format("The Urgencia Id %s is different from the Url Id",urgenciaDTO.getId());
        this.urgenciaService.deleteUrgencia(urgenciaDTO);
    }
}
