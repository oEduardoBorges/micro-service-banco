package com.edwborges.mappers.response;

import com.edwborges.dtos.response.CartaoResponse;
import com.edwborges.mappers.generic.GenericMapper;
import com.edwborges.models.Cartao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartaoResponseMapper extends GenericMapper<Cartao, CartaoResponse> {

    CartaoResponseMapper INSTANCE = Mappers.getMapper(CartaoResponseMapper.class);
}
