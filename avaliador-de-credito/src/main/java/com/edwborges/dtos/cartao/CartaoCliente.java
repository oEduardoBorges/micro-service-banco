package com.edwborges.dtos.cartao;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoCliente {

    private String nome;

    private String bandeira;

    private BigDecimal limite;
}
