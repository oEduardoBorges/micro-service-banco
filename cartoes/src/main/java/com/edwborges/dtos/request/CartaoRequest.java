package com.edwborges.dtos.request;

import com.edwborges.models.enums.BandeiraCartao;

import java.math.BigDecimal;

public record CartaoRequest(

        String nome,
        BandeiraCartao bandeiraCartao,
        BigDecimal renda,
        BigDecimal limite
){}
