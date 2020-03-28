package com.vivienda.persistence.repository;

import com.vivienda.persistence.model.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Material,Integer> {
}
