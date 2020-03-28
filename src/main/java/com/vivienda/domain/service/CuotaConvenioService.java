package com.vivienda.domain.service;

import com.vivienda.api.dto.CuotaConvenioDTO;
import com.vivienda.domain.mappers.CuotaConvenioMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.CuotaConvenioDAO;
import com.vivienda.persistence.model.CuotaConvenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuotaConvenioService {

    private final CuotaConvenioDAO cuotaConvenioDAO;

    private final CuotaConvenioMapper cuotaConvenioMapper;


    @Autowired
    public CuotaConvenioService(CuotaConvenioMapper cuotaConvenioMapper, CuotaConvenioDAO cuotaConvenioDAO){
        this.cuotaConvenioDAO = cuotaConvenioDAO;
        this.cuotaConvenioMapper = cuotaConvenioMapper;
    }

    public CuotaConvenioDTO saveCuotaConvenio(CuotaConvenioDTO cuotaConvenioDTO) throws ServiceException {
        CuotaConvenio CuotaConvenio = cuotaConvenioMapper.mapToEntity(cuotaConvenioDTO);
        return cuotaConvenioMapper.mapToDTO(this.cuotaConvenioDAO.saveCuotaConvenio(CuotaConvenio));
    }

    public void deleteCuotaConvenio(CuotaConvenioDTO cuotaConvenioDTO){
        this.cuotaConvenioDAO.deleteCuotaConvenio(cuotaConvenioDTO.getId());
    }

    public CuotaConvenioDTO updateCuotaConvenio(CuotaConvenioDTO cuotaConvenioDTO) throws ServiceException{
        try {
            return this.cuotaConvenioMapper.mapToDTO(this.cuotaConvenioDAO.updateCuotaConvenio(cuotaConvenioMapper.mapToEntity(cuotaConvenioDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<CuotaConvenioDTO> getCuotaConvenios(){
        List<CuotaConvenio> CuotaConvenios = this.cuotaConvenioDAO.getCuotaConvenios();
        return CuotaConvenios.stream().map(cuotaConvenio -> this.cuotaConvenioMapper.mapToDTO(cuotaConvenio)).collect(Collectors.toList());
    }

    public CuotaConvenioDTO getCuotaConvenioById(Integer id) throws ServiceException{
        return this.cuotaConvenioMapper.mapToDTO(this.cuotaConvenioDAO.getCuotaConvenioById(id));
    }
}
