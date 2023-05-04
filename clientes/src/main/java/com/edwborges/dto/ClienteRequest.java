package com.edwborges.dto;

import jakarta.persistence.Column;

public record ClienteRequest(

        @Column(unique = true)
        String cpf,
        String nome,
        Integer idade
){
        public ClienteRequest {
                if(nome != null) nome = nome.trim();
        }
}
