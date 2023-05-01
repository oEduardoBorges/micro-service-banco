package com.borges.mapper.response;

import com.borges.dto.ClienteResponse;
import com.borges.mapper.generic.GenericMapper;
import com.borges.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteResponseMapper extends GenericMapper<Cliente, ClienteResponse> {

    ClienteResponseMapper INSTANCE = Mappers.getMapper(ClienteResponseMapper.class);
}
