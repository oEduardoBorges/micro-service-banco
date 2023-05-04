package com.edwborges.mappers.generic;

import java.util.List;

public interface GenericMapper<E, DTO> {

    DTO entityToDTO(E entity);

    E dtoToEntity(DTO dto);

    List<DTO> listEntityToListDTO(List<E> lista);
}
