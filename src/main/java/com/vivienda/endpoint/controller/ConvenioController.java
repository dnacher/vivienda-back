package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.ConvenioDTO;
import com.vivienda.domain.service.ConvenioService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/convenios")
public class ConvenioController {

    private final ConvenioService convenioService;

    @Autowired
    public ConvenioController(ConvenioService convenioService){
        this.convenioService = convenioService;
    }

    @PostMapping(value = "/mul")
    public List<ConvenioDTO> saveConceptos(@RequestBody List<ConvenioDTO> convenioDTOS){
        List<ConvenioDTO> finalList = new ArrayList<>();
        convenioDTOS.forEach(convenioDTO -> {
            try {
                finalList.add(this.convenioService.saveConvenio(convenioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<ConvenioDTO> updateConvenio(@RequestBody List<ConvenioDTO> convenioDTOS){
        List<ConvenioDTO> finalList = new ArrayList<>();
        convenioDTOS.forEach(convenioDTO -> {
            try {
                finalList.add(this.convenioService.updateConvenio(convenioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public ConvenioDTO saveConvenio(ConvenioDTO convenioDTO) throws ServiceException {
        return this.convenioService.saveConvenio(convenioDTO);
    }

    @PutMapping(value = "/{id}")
    public ConvenioDTO updateConvenio(@PathVariable Integer id, @RequestBody ConvenioDTO convenioDTO) throws ServiceException {
        String msg = String.format("The Convenio Id %s is different from the Url Id",convenioDTO.getId());
        return this.convenioService.saveConvenio(convenioDTO);
    }

    @GetMapping(value = "/")
    public List<ConvenioDTO> getConvenios(){
        return this.convenioService.getConvenios();
    }

    @GetMapping(value = "/{id}")
    public ConvenioDTO getConvenioById(@PathVariable Integer id) throws ServiceException {
        return this.convenioService.getConvenioById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteConvenio(@PathVariable Integer id, ConvenioDTO conceptoDTO){
        String msg = String.format("The Convenio Id %s is different from the Url Id",conceptoDTO.getId());
        this.convenioService.deleteConvenio(conceptoDTO);
    }

}
