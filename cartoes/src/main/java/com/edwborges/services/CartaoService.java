package com.edwborges.services;

import com.edwborges.dtos.request.CartaoRequest;
import com.edwborges.dtos.response.CartaoResponse;
import com.edwborges.mappers.request.CartaoRequestMapper;
import com.edwborges.mappers.response.CartaoResponseMapper;
import com.edwborges.models.Cartao;
import com.edwborges.repositories.CartaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    public CartaoResponse salvar(CartaoRequest cartaoRequest) {
        Cartao cartao = CartaoRequestMapper.INSTANCE.dtoToEntity(cartaoRequest);
        cartaoRepository.save(cartao);
        return CartaoResponseMapper.INSTANCE.entityToDTO(cartao);
    }

    public List<CartaoResponse> buscarCartoesRendaMenorIgual(Long renda){
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
