package com.edwborges.dtos.response;

import com.edwborges.models.enums.BandeiraCartao;

import java.math.BigDecimal;

public record CartaoResponse(

        Long cartaoId,
        String nome,
        BandeiraCartao bandeiraCartao,
        BigDecimal renda,
        BigDecimal limite
){}
