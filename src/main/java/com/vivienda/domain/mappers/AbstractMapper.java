package com.vivienda.domain.mappers;

public interface AbstractMapper<T,S> {

    T mapToEntity(S dto);

    S mapToDTO(T entity);

}
