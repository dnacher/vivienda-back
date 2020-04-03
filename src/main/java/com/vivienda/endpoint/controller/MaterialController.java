package com.vivienda.endpoint.controller;

import com.vivienda.api.dto.MaterialDTO;
import com.vivienda.domain.service.MaterialService;
import com.vivienda.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/materiales")
public class MaterialController {
    
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService){
        this.materialService= materialService;
    }

    @PostMapping(value = "/mul")
    public List<MaterialDTO> saveMaterials(@RequestBody List<MaterialDTO> materialDTOS){
        List<MaterialDTO> finalList = new ArrayList<>();
        materialDTOS.forEach(materialDTO -> {
            try {
                finalList.add(this.materialService.saveMaterial(materialDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PutMapping(value = "/mul")
    public List<MaterialDTO> updateMaterial(@RequestBody List<MaterialDTO> materialDTOS){
        List<MaterialDTO> finalList = new ArrayList<>();
        materialDTOS.forEach(materialDTO -> {
            try {
                finalList.add(this.materialService.updateMaterial(materialDTO));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
        return finalList;
    }

    @PostMapping(value = "/")
    public MaterialDTO saveMaterial(MaterialDTO materialDTO) throws ServiceException {
        return this.materialService.saveMaterial(materialDTO);
    }

    @PutMapping(value = "/{id}")
    public MaterialDTO updateMaterial(@PathVariable Integer id, @RequestBody MaterialDTO materialDTO) throws ServiceException {
        String msg = String.format("The Material Id %s is different from the Url Id",materialDTO.getId());
        return this.materialService.saveMaterial(materialDTO);
    }

    @GetMapping(value = "/")
    public List<MaterialDTO> getMateriales(){
        return this.materialService.getMaterials();
    }

    @GetMapping(value = "/{id}")
    public MaterialDTO getMaterialById(@PathVariable Integer id) throws ServiceException {
        return this.materialService.getMaterialById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMaterial(@PathVariable Integer id, MaterialDTO materialDTO){
        String msg = String.format("The Material Id %s is different from the Url Id",materialDTO.getId());
        this.materialService.deleteMaterial(materialDTO);
    }
}
