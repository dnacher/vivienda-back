package com.vivienda.domain.service;

import com.vivienda.api.dto.ConceptoDTO;
import com.vivienda.domain.mappers.ConceptoMapper;
import com.vivienda.exception.ServiceException;
import com.vivienda.persistence.dao.ConceptoDAO;
import com.vivienda.persistence.model.Concepto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConceptoService {

    private final ConceptoDAO conceptoDAO;

    private final ConceptoMapper conceptoMapper;


    @Autowired
    public ConceptoService(ConceptoMapper conceptoMapper, ConceptoDAO conceptoDAO){
        this.conceptoDAO = conceptoDAO;
        this.conceptoMapper = conceptoMapper;
    }

    public ConceptoDTO saveConcepto(ConceptoDTO conceptoDTO) throws ServiceException {
        Concepto concepto = conceptoMapper.mapToEntity(conceptoDTO);
        return conceptoMapper.mapToDTO(this.conceptoDAO.saveConcepto(concepto));
    }

    public void deleteConcepto(ConceptoDTO conceptoDTO){
        this.conceptoDAO.deleteConcepto(conceptoDTO.getId());
    }

    public ConceptoDTO updateConcepto(ConceptoDTO conceptoDTO) throws ServiceException{
        try {
            return this.conceptoMapper.mapToDTO(this.conceptoDAO.updateConcepto(conceptoMapper.mapToEntity(conceptoDTO)));
        }catch (ServiceException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<ConceptoDTO> getConceptos(){
        List<Concepto> Conceptos = this.conceptoDAO.getConceptos();
        return Conceptos.stream().map(concepto -> this.conceptoMapper.mapToDTO(concepto)).collect(Collectors.toList());
    }

    public ConceptoDTO getConceptoById(Integer id) throws ServiceException{
        return this.conceptoMapper.mapToDTO(this.conceptoDAO.getConceptoById(id));
    }

}
