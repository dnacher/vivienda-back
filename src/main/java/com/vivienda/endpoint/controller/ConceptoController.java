package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.ConceptoDTO;
import com.vivienda.domain.service.ConceptoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/conceptos")
public class ConceptoController {

    private final ConceptoService conceptoService;

    @Autowired
    public ConceptoController(ConceptoService conceptoService){
        this.conceptoService = conceptoService;
    }

    @PostMapping(value = "/mul")
    public List<ConceptoDTO> saveConceptos(@RequestBody List<ConceptoDTO> attendanceDTOS){
        List<ConceptoDTO> finalList = new ArrayList<>();
        attendanceDTOS.forEach(conceptoDTO -> {
            try {
                finalList.add(this.conceptoService.saveConcepto(conceptoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<ConceptoDTO> updateConceptos(@RequestBody List<ConceptoDTO> conceptoDTOS){
        List<ConceptoDTO> finalList = new ArrayList<>();
        conceptoDTOS.forEach(conceptoDTO -> {
            try {
                finalList.add(this.conceptoService.updateConcepto(conceptoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public ConceptoDTO saveConcepto(ConceptoDTO conceptoDTO) throws ServiceException {
        return this.conceptoService.saveConcepto(conceptoDTO);
    }

    @PutMapping(value = "/{id}")
    public ConceptoDTO updateConcepto(@PathVariable Integer id, @RequestBody ConceptoDTO conceptoDTO) throws ServiceException {
        String msg = String.format("The Concepto Id %s is different from the Url Id",conceptoDTO.getId());
        return this.conceptoService.saveConcepto(conceptoDTO);
    }

    @GetMapping(value = "/")
    public List<ConceptoDTO> getConcepto(){
        return this.conceptoService.getConceptos();
    }

    @GetMapping(value = "/{id}")
    public ConceptoDTO getConceptoById(@PathVariable Integer id) throws ServiceException {
        return this.conceptoService.getConceptoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteConcepto(@PathVariable Integer id, ConceptoDTO conceptoDTO){
        String msg = String.format("The Concepto Id %s is different from the Url Id",conceptoDTO.getId());
        this.conceptoService.deleteConcepto(conceptoDTO);
    }
}
