package com.edwborges.dtos.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CartoesPorClienteResponse(
    String nome,
    String bandeiraCartao,
    BigDecimal limite
){}
