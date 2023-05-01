package com.borges.dto;

public record ClienteResponse(

        Long clienteId,
        String cpf,
        String nome,
        Integer idade
){}
