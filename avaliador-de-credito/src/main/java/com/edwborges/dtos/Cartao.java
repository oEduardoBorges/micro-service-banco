package com.edwborges.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cartao {

    private Long cartaoId;
    private String nome;
    private String bandeiraCartao;
    private BigDecimal limite;
}
