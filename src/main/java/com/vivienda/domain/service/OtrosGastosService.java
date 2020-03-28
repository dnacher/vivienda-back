package com.vivienda.domain.service;

import com.vivienda.api.dto.OtrosGastosDTO;
import com.vivienda.domain.mappers.OtrosGastosMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.OtrosGastosDAO;
import com.vivienda.persistence.model.OtrosGastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OtrosGastosService {

    private final com.vivienda.persistence.dao.OtrosGastosDAO OtrosGastosDAO;

    private final com.vivienda.domain.mappers.OtrosGastosMapper OtrosGastosMapper;


    @Autowired
    public OtrosGastosService(OtrosGastosMapper OtrosGastosMapper, OtrosGastosDAO OtrosGastosDAO){
        this.OtrosGastosDAO = OtrosGastosDAO;
        this.OtrosGastosMapper = OtrosGastosMapper;
    }

    public OtrosGastosDTO saveOtrosGastos(OtrosGastosDTO OtrosGastosDTO) throws ServiceException {
        OtrosGastos OtrosGastos = OtrosGastosMapper.mapToEntity(OtrosGastosDTO);
        return OtrosGastosMapper.mapToDTO(this.OtrosGastosDAO.saveOtrosGastos(OtrosGastos));
    }

    public void deleteOtrosGastos(OtrosGastosDTO OtrosGastosDTO){
        this.OtrosGastosDAO.deleteOtrosGastos(OtrosGastosDTO.getId());
    }

    public OtrosGastosDTO updateOtrosGastos(OtrosGastosDTO OtrosGastosDTO) throws ServiceException{
        try {
            return this.OtrosGastosMapper.mapToDTO(this.OtrosGastosDAO.updateOtrosGastos(OtrosGastosMapper.mapToEntity(OtrosGastosDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<OtrosGastosDTO> getOtrosGastos(){
        List<OtrosGastos> OtrosGastoss = this.OtrosGastosDAO.getOtrosGastos();
        return OtrosGastoss.stream().map(otrosGastos -> this.OtrosGastosMapper.mapToDTO(otrosGastos)).collect(Collectors.toList());
    }

    public OtrosGastosDTO getOtrosGastosById(Integer id) throws ServiceException{
        return this.OtrosGastosMapper.mapToDTO(this.OtrosGastosDAO.getOtrosGastosById(id));
    }
}
