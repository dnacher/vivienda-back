package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.EstadoDTO;
import com.vivienda.domain.service.EstadoService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService estadoService;

    @Autowired
    public EstadoController(EstadoService estadoService){
        this.estadoService = estadoService;
    }

    @PostMapping(value = "/mul")
    public List<EstadoDTO> saveEstados(@RequestBody List<EstadoDTO> estadoDTOS){
        List<EstadoDTO> finalList = new ArrayList<>();
        estadoDTOS.forEach(EstadoDTO -> {
            try {
                finalList.add(this.estadoService.saveEstado(EstadoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<EstadoDTO> updateEstado(@RequestBody List<EstadoDTO> estadoDTOS){
        List<EstadoDTO> finalList = new ArrayList<>();
        estadoDTOS.forEach(EstadoDTO -> {
            try {
                finalList.add(this.estadoService.updateEstado(EstadoDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public EstadoDTO saveEstado(EstadoDTO estadoDTO) throws ServiceException {
        return this.estadoService.saveEstado(estadoDTO);
    }

    @PutMapping(value = "/{id}")
    public EstadoDTO updateEstado(@PathVariable Integer id, @RequestBody EstadoDTO estadoDTO) throws ServiceException {
        String msg = String.format("The Estado Id %s is different from the Url Id",estadoDTO.getId());
        return this.estadoService.saveEstado(estadoDTO);
    }

    @GetMapping(value = "/")
    public List<EstadoDTO> getEstados(){
        return this.estadoService.getEstados();
    }

    @GetMapping(value = "/{id}")
    public EstadoDTO getEstadoById(@PathVariable Integer id) throws ServiceException {
        return this.estadoService.getEstadoById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEstado(@PathVariable Integer id, EstadoDTO estadoDTO){
        String msg = String.format("The Estado Id %s is different from the Url Id",estadoDTO.getId());
        this.estadoService.deleteEstado(estadoDTO);
    }
}
