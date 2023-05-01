package com.borges.mapper.request;

import com.borges.dto.ClienteRequest;
import com.borges.mapper.generic.GenericMapper;
import com.borges.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteRequestMapper extends GenericMapper<Cliente, ClienteRequest> {

    ClienteRequestMapper  INSTANCE = Mappers.getMapper(ClienteRequestMapper.class);
}
