package com.edwborges.mapper.request;

import com.edwborges.dto.ClienteRequest;
import com.edwborges.mapper.generic.GenericMapper;
import com.edwborges.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteRequestMapper extends GenericMapper<Cliente, ClienteRequest> {

    ClienteRequestMapper  INSTANCE = Mappers.getMapper(ClienteRequestMapper.class);
}
