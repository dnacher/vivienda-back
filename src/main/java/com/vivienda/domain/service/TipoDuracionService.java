package com.vivienda.domain.service;

import com.vivienda.api.dto.TipoDuracionDTO;
import com.vivienda.domain.mappers.TipoDuracionMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.TipoDuracionDAO;
import com.vivienda.persistence.model.TipoDuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDuracionService {

    private final TipoDuracionDAO tipoDuracionDAO;

    private final TipoDuracionMapper tipoDuracionMapper;


    @Autowired
    public TipoDuracionService(TipoDuracionMapper tipoDuracionMapper, TipoDuracionDAO tipoDuracionDAO){
        this.tipoDuracionDAO = tipoDuracionDAO;
        this.tipoDuracionMapper = tipoDuracionMapper;
    }

    public TipoDuracionDTO saveTipoDuracion(TipoDuracionDTO tipoDuracionDTO) throws ServiceException {
        TipoDuracion TipoDuracion = tipoDuracionMapper.mapToEntity(tipoDuracionDTO);
        return tipoDuracionMapper.mapToDTO(this.tipoDuracionDAO.saveTipoDuracion(TipoDuracion));
    }

    public void deleteTipoDuracion(TipoDuracionDTO tipoDuracionDTO){
        this.tipoDuracionDAO.deleteTipoDuracion(tipoDuracionDTO.getId());
    }

    public TipoDuracionDTO updateTipoDuracion(TipoDuracionDTO tipoDuracionDTO) throws ServiceException{
        try {
            return this.tipoDuracionMapper.mapToDTO(this.tipoDuracionDAO.updateTipoDuracion(tipoDuracionMapper.mapToEntity(tipoDuracionDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<TipoDuracionDTO> getTipoDuracions(){
        List<TipoDuracion> TipoDuracions = this.tipoDuracionDAO.getTipoDuracion();
        return TipoDuracions.stream().map(tipoDuracion -> this.tipoDuracionMapper.mapToDTO(tipoDuracion)).collect(Collectors.toList());
    }

    public TipoDuracionDTO getTipoDuracionById(Integer id) throws ServiceException{
        return this.tipoDuracionMapper.mapToDTO(this.tipoDuracionDAO.getTipoDuracionById(id));
    }
}
