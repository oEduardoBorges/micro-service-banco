package com.edwborges.services;

import com.edwborges.dtos.response.CartoesPorClienteResponse;
import com.edwborges.exceptions.GenericException;
import com.edwborges.models.ClienteCartao;
import com.edwborges.repositories.ClienteCartaoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteCartaoService {

    private final ClienteCartaoRepository clienteCartaoRepository;

    public ClienteCartaoService(ClienteCartaoRepository clienteCartaoRepository) {
        this.clienteCartaoRepository = clienteCartaoRepository;
    }

    public List<CartoesPorClienteResponse> listaCartoesPorCpf(String cpf){
        List<ClienteCartao> cartoes = clienteCartaoRepository.findByCpf(cpf);
        if(cartoes.isEmpty()) {
            throw new GenericException("Este cliente não tem nenhum cartão cadastrado.");
        }
        List<CartoesPorClienteResponse> build = Collections.singletonList(CartoesPorClienteResponse.builder()
                .nome(cartoes.get(1).getCartao().getNome())
                .bandeiraCartao(cartoes.get(1).getCartao().getBandeiraCartao().toString())
                .limite(cartoes.get(1).getLimite())
                .build());
        return build;
    }
}
