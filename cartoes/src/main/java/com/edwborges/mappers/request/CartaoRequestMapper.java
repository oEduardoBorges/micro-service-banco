package com.edwborges.mappers.request;

import com.edwborges.dtos.request.CartaoRequest;
import com.edwborges.mappers.generic.GenericMapper;
import com.edwborges.models.Cartao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartaoRequestMapper extends GenericMapper<Cartao, CartaoRequest> {

    CartaoRequestMapper  INSTANCE = Mappers.getMapper(CartaoRequestMapper.class);
}
