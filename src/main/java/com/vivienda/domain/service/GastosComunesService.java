package com.vivienda.domain.service;

import com.vivienda.api.dto.GastosComunesDTO;
import com.vivienda.domain.mappers.GastosComunesMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.GastosComunesDAO;
import com.vivienda.persistence.model.GastosComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GastosComunesService {

    private final GastosComunesDAO gastosComunesDAO;

    private final GastosComunesMapper gastosComunesMapper;


    @Autowired
    public GastosComunesService(GastosComunesMapper gastosComunesMapper, GastosComunesDAO gastosComunesDAO){
        this.gastosComunesDAO = gastosComunesDAO;
        this.gastosComunesMapper = gastosComunesMapper;
    }

    public GastosComunesDTO saveGastosComunes(GastosComunesDTO gastosComunesDTO) throws ServiceException {
        GastosComunes GastosComunes = gastosComunesMapper.mapToEntity(gastosComunesDTO);
        return gastosComunesMapper.mapToDTO(this.gastosComunesDAO.saveGastosComunes(GastosComunes));
    }

    public void deleteGastosComunes(GastosComunesDTO gastosComunesDTO){
        this.gastosComunesDAO.deleteGastosComunes(gastosComunesDTO.getId());
    }

    public GastosComunesDTO updateGastosComunes(GastosComunesDTO gastosComunesDTO) throws ServiceException{
        try {
            return this.gastosComunesMapper.mapToDTO(this.gastosComunesDAO.updateGastosComunes(gastosComunesMapper.mapToEntity(gastosComunesDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<GastosComunesDTO> getGastosComuness(){
        List<GastosComunes> GastosComuness = this.gastosComunesDAO.getGastosComunes();
        return GastosComuness.stream().map(gastosComunes -> this.gastosComunesMapper.mapToDTO(gastosComunes)).collect(Collectors.toList());
    }

    public GastosComunesDTO getGastosComunesById(Integer id) throws ServiceException{
        return this.gastosComunesMapper.mapToDTO(this.gastosComunesDAO.getGastosComunesById(id));
    }
}
