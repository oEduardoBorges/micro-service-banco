package com.edwborges.mapper.response;

import com.edwborges.dto.ClienteResponse;
import com.edwborges.mapper.generic.GenericMapper;
import com.edwborges.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteResponseMapper extends GenericMapper<Cliente, ClienteResponse> {

    ClienteResponseMapper INSTANCE = Mappers.getMapper(ClienteResponseMapper.class);
}
