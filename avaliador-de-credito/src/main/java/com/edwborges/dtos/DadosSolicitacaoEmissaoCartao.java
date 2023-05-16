package com.edwborges.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosSolicitacaoEmissaoCartao {

    private Long cartaoId;
    private String cpf;
    private BigDecimal limite;
}
