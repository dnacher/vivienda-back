package com.vivienda.domain.service;

import com.vivienda.api.dto.EstadoDTO;
import com.vivienda.domain.mappers.EstadoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.EstadoDAO;
import com.vivienda.persistence.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    private final EstadoDAO EstadoDAO;

    private final EstadoMapper EstadoMapper;


    @Autowired
    public EstadoService(EstadoMapper estadoMapper, EstadoDAO estadoDAO){
        this.EstadoDAO = estadoDAO;
        this.EstadoMapper = estadoMapper;
    }

    public EstadoDTO saveEstado(EstadoDTO estadoDTO) throws ServiceException {
        Estado Estado = EstadoMapper.mapToEntity(estadoDTO);
        return EstadoMapper.mapToDTO(this.EstadoDAO.saveEstado(Estado));
    }

    public void deleteEstado(EstadoDTO estadoDTO){
        this.EstadoDAO.deleteEstado(estadoDTO.getId());
    }

    public EstadoDTO updateEstado(EstadoDTO estadoDTO) throws ServiceException{
        try {
            return this.EstadoMapper.mapToDTO(this.EstadoDAO.updateEstado(EstadoMapper.mapToEntity(estadoDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<EstadoDTO> getEstados(){
        List<Estado> Estados = this.EstadoDAO.getEstados();
        return Estados.stream().map(Estado -> this.EstadoMapper.mapToDTO(Estado)).collect(Collectors.toList());
    }

    public EstadoDTO getEstadoById(Integer id) throws ServiceException{
        return this.EstadoMapper.mapToDTO(this.EstadoDAO.getEstadoById(id));
    }
}
