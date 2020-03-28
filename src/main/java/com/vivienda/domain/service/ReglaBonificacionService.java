package com.vivienda.domain.service;

import com.vivienda.api.dto.ReglaBonificacionDTO;
import com.vivienda.domain.mappers.ReglaBonificacionMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.ReglaBonificacionDAO;
import com.vivienda.persistence.model.ReglaBonificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReglaBonificacionService {

    private final ReglaBonificacionDAO ReglaBonificacionDAO;

    private final ReglaBonificacionMapper ReglaBonificacionMapper;

    @Autowired
    public ReglaBonificacionService(ReglaBonificacionMapper reglaBonificacionMapper, ReglaBonificacionDAO reglaBonificacionDAO){
        this.ReglaBonificacionDAO = reglaBonificacionDAO;
        this.ReglaBonificacionMapper = reglaBonificacionMapper;
    }

    public ReglaBonificacionDTO saveReglaBonificacion(ReglaBonificacionDTO reglaBonificacionDTO) throws ServiceException {
        ReglaBonificacion ReglaBonificacion = ReglaBonificacionMapper.mapToEntity(reglaBonificacionDTO);
        return ReglaBonificacionMapper.mapToDTO(this.ReglaBonificacionDAO.saveReglaBonificacion(ReglaBonificacion));
    }

    public void deleteReglaBonificacion(ReglaBonificacionDTO reglaBonificacionDTO){
        this.ReglaBonificacionDAO.deleteReglaBonificacion(reglaBonificacionDTO.getId());
    }

    public ReglaBonificacionDTO updateReglaBonificacion(ReglaBonificacionDTO reglaBonificacionDTO) throws ServiceException{
        try {
            return this.ReglaBonificacionMapper.mapToDTO(this.ReglaBonificacionDAO.updateReglaBonificacion(ReglaBonificacionMapper.mapToEntity(reglaBonificacionDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<ReglaBonificacionDTO> getReglaBonificacions(){
        List<ReglaBonificacion> ReglaBonificacions = this.ReglaBonificacionDAO.getReglasBonificacion();
        return ReglaBonificacions.stream().map(reglaBonificacion -> this.ReglaBonificacionMapper.mapToDTO(reglaBonificacion)).collect(Collectors.toList());
    }

    public ReglaBonificacionDTO getReglaBonificacionById(Integer id) throws ServiceException{
        return this.ReglaBonificacionMapper.mapToDTO(this.ReglaBonificacionDAO.getReglaBonificacionById(id));
    }
}
