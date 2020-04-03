package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.ListaPrecioDTO;
import com.vivienda.domain.service.ListaPrecioService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/lista_precios")
public class ListaPrecioController {
    
    private final ListaPrecioService listaPrecioService;

    @Autowired
    public ListaPrecioController(ListaPrecioService listaPrecioService){
        this.listaPrecioService = listaPrecioService;
    }

    @PostMapping(value = "/mul")
    public List<ListaPrecioDTO> saveListaPrecios(@RequestBody List<ListaPrecioDTO> listaPrecioDTOS){
        List<ListaPrecioDTO> finalList = new ArrayList<>();
        listaPrecioDTOS.forEach(listaPrecioDTO -> {
            try {
                finalList.add(this.listaPrecioService.saveListaPrecio(listaPrecioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<ListaPrecioDTO> updateListaPrecio(@RequestBody List<ListaPrecioDTO> listaPrecioDTOS){
        List<ListaPrecioDTO> finalList = new ArrayList<>();
        listaPrecioDTOS.forEach(listaPrecioDTO -> {
            try {
                finalList.add(this.listaPrecioService.updateListaPrecio(listaPrecioDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public ListaPrecioDTO saveListaPrecio(ListaPrecioDTO listaPrecioDTO) throws ServiceException {
        return this.listaPrecioService.saveListaPrecio(listaPrecioDTO);
    }

    @PutMapping(value = "/{id}")
    public ListaPrecioDTO updateListaPrecio(@PathVariable Integer id, @RequestBody ListaPrecioDTO listaPrecioDTO) throws ServiceException {
        String msg = String.format("The Lista de precio Id %s is different from the Url Id",listaPrecioDTO.getId());
        return this.listaPrecioService.saveListaPrecio(listaPrecioDTO);
    }

    @GetMapping(value = "/")
    public List<ListaPrecioDTO> getListaPrecios(){
        return this.listaPrecioService.getListaPrecios();
    }

    @GetMapping(value = "/{id}")
    public ListaPrecioDTO getListaPrecioById(@PathVariable Integer id) throws ServiceException {
        return this.listaPrecioService.getListaPrecioById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteListaPrecio(@PathVariable Integer id, ListaPrecioDTO listaPrecioDTO){
        String msg = String.format("The Lista de Precio Id %s is different from the Url Id",listaPrecioDTO.getId());
        this.listaPrecioService.deleteListaPrecio(listaPrecioDTO);
    }

}
