package com.edwborges.service;

import com.edwborges.clients.CartoesClient;
import com.edwborges.clients.ClienteClient;
import com.edwborges.dtos.cartao.CartaoCliente;
import com.edwborges.dtos.cliente.DadosCliente;
import com.edwborges.dtos.SituacaoCliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoCreditoService {

    private final ClienteClient clienteClient;
    private final CartoesClient cartoesClient;

    public AvaliacaoCreditoService(ClienteClient clienteClient, CartoesClient cartoesClient) {
        this.clienteClient = clienteClient;
        this.cartoesClient = cartoesClient;
    }

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosClientePorCpf = clienteClient.buscarPorCpf(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesClientePorCpf = cartoesClient.CartoesPorCpfCliente(cpf);

        return SituacaoCliente.builder()
                .cliente(dadosClientePorCpf.getBody())
                .cartoes(cartoesClientePorCpf.getBody())
                .build();
    }
}
