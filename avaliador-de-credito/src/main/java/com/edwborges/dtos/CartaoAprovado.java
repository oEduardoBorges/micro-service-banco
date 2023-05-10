package com.edwborges.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoAprovado {

    private String cartao;

    private String bandeiraCartao;

    private BigDecimal limiteAprovado;
}
