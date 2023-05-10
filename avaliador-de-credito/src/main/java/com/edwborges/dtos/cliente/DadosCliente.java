package com.edwborges.dtos.cliente;

import lombok.Data;

@Data
public class DadosCliente {

    private Long clienteId;

    private String cpf;

    private String nome;

    private Integer idade;
}
