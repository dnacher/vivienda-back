package com.vivienda.domain.service;

import com.vivienda.api.dto.ListaPrecioDTO;
import com.vivienda.domain.mappers.ListaPrecioMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.ListaPrecioDAO;
import com.vivienda.persistence.model.ListaPrecio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaPrecioService {

    private final com.vivienda.persistence.dao.ListaPrecioDAO ListaPrecioDAO;

    private final com.vivienda.domain.mappers.ListaPrecioMapper ListaPrecioMapper;


    @Autowired
    public ListaPrecioService(ListaPrecioMapper ListaPrecioMapper, ListaPrecioDAO ListaPrecioDAO){
        this.ListaPrecioDAO = ListaPrecioDAO;
        this.ListaPrecioMapper = ListaPrecioMapper;
    }

    public ListaPrecioDTO saveListaPrecio(ListaPrecioDTO ListaPrecioDTO) throws ServiceException {
        ListaPrecio ListaPrecio = ListaPrecioMapper.mapToEntity(ListaPrecioDTO);
        return ListaPrecioMapper.mapToDTO(this.ListaPrecioDAO.saveListaPrecio(ListaPrecio));
    }

    public void deleteListaPrecio(ListaPrecioDTO ListaPrecioDTO){
        this.ListaPrecioDAO.deleteListaPrecio(ListaPrecioDTO.getId());
    }

    public ListaPrecioDTO updateListaPrecio(ListaPrecioDTO ListaPrecioDTO) throws ServiceException{
        try {
            return this.ListaPrecioMapper.mapToDTO(this.ListaPrecioDAO.updateListaPrecio(ListaPrecioMapper.mapToEntity(ListaPrecioDTO)));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<ListaPrecioDTO> getListaPrecios(){
        List<ListaPrecio> ListaPrecios = this.ListaPrecioDAO.getListaPrecio();
        return ListaPrecios.stream().map(listaPrecio -> this.ListaPrecioMapper.mapToDTO(listaPrecio)).collect(Collectors.toList());
    }

    public ListaPrecioDTO getListaPrecioById(Integer id) throws ServiceException{
        return this.ListaPrecioMapper.mapToDTO(this.ListaPrecioDAO.getListaPrecioById(id));
    }
}
