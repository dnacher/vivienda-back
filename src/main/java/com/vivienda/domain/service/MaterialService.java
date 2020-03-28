package com.vivienda.domain.service;

import com.vivienda.api.dto.MaterialDTO;
import com.vivienda.domain.mappers.MaterialMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.MaterialDAO;
import com.vivienda.persistence.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    private final MaterialDAO materialDAO;

    private final MaterialMapper materialMapper;


    @Autowired
    public MaterialService(MaterialMapper materialMapper, MaterialDAO materialDAO){
        this.materialDAO = materialDAO;
        this.materialMapper = materialMapper;
    }

    public MaterialDTO saveMaterial(MaterialDTO materialDTO) throws ServiceException {
        Material Material = materialMapper.mapToEntity(materialDTO);
        return materialMapper.mapToDTO(this.materialDAO.saveMaterial(Material));
    }

    public void deleteMaterial(MaterialDTO materialDTO){
        this.materialDAO.deleteMaterial(materialDTO.getId());
    }

    public MaterialDTO updateMaterial(MaterialDTO materialDTO) throws ServiceException{
        try {
            return this.materialMapper.mapToDTO(this.materialDAO.updateMaterial(materialMapper.mapToEntity(materialDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<MaterialDTO> getMaterials(){
        List<Material> Materials = this.materialDAO.getMateriales();
        return Materials.stream().map(material -> this.materialMapper.mapToDTO(material)).collect(Collectors.toList());
    }

    public MaterialDTO getMaterialById(Integer id) throws ServiceException{
        return this.materialMapper.mapToDTO(this.materialDAO.getMaterialById(id));
    }
}
