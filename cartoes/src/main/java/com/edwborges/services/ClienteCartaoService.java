package com.edwborges.services;

import com.edwborges.dtos.response.CartoesPorClienteResponse;
import com.edwborges.exceptions.GenericException;
import com.edwborges.models.ClienteCartao;
import com.edwborges.repositories.ClienteCartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCartaoService {

    private final ClienteCartaoRepository clienteCartaoRepository;

    public ClienteCartaoService(ClienteCartaoRepository clienteCartaoRepository) {
        this.clienteCartaoRepository = clienteCartaoRepository;
    }

    public List<ClienteCartao> listaCartoesPorCpf(String cpf){
        List<ClienteCartao> cartoes = clienteCartaoRepository.findByCpf(cpf);
        if(cartoes.isEmpty()) {
            throw new GenericException("Este cliente não tem nenhum cartão cadastrado.");
        }
        return cartoes;
    }
}
