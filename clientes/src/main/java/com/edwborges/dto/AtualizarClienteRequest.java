package com.edwborges.dto;

public record AtualizarClienteRequest(

        String nome
){
    public AtualizarClienteRequest {
        if(nome != null) nome = nome.trim();
    }
}
