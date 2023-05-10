package com.edwborges.service;

import com.edwborges.clients.CartoesClient;
import com.edwborges.clients.ClienteClient;
import com.edwborges.dtos.CartaoAprovado;
import com.edwborges.dtos.RetornoAvaliacaoCliente;
import com.edwborges.dtos.cartao.CartaoCliente;
import com.edwborges.dtos.cliente.DadosCliente;
import com.edwborges.dtos.SituacaoCliente;
import com.edwborges.exceptions.DadosClienteNotFoundException;
import com.edwborges.exceptions.ErroComunicacaoMicroservicesException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvaliacaoCreditoService {

    private final ClienteClient clienteClient;
    private final CartoesClient cartoesClient;

    public AvaliacaoCreditoService(ClienteClient clienteClient, CartoesClient cartoesClient) {
        this.clienteClient = clienteClient;
        this.cartoesClient = cartoesClient;
    }

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
        try {
            ResponseEntity<DadosCliente> dadosClientePorCpf = clienteClient.buscarPorCpf(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesClientePorCpf = cartoesClient.getCartoesPorCliente(cpf);

            return SituacaoCliente.builder()
                    .cliente(dadosClientePorCpf.getBody())
                    .cartoes(cartoesClientePorCpf.getBody())
                    .build();

        }catch(FeignException.FeignClientException e) {
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException("Dados do cliente não encontrado para o CPF informado");
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }

    public RetornoAvaliacaoCliente realizarAvaliacao(String cpf, Long renda) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
        try {
            ResponseEntity<DadosCliente> buscarPorCpf = clienteClient.buscarPorCpf(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesRendaAte = cartoesClient.getCartoesRendaAte(renda);

            List<CartaoCliente> cartoes = cartoesRendaAte.getBody();
            var listaCartoesAprovados = cartoes.stream().map(cartao -> {

                DadosCliente dadosCliente = buscarPorCpf.getBody();

                BigDecimal limite = cartao.getLimite();
                BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
                BigDecimal idadeBigDecimal = BigDecimal.valueOf(dadosCliente.getIdade());
                var fator = idadeBigDecimal.divide(BigDecimal.valueOf(10));
                BigDecimal limiteAprovado = fator.multiply(limite);

                CartaoAprovado cartaoAprovado = new CartaoAprovado();
                cartaoAprovado.setCartao(cartao.getNome());
                cartaoAprovado.setBandeiraCartao(cartao.getBandeiraCartao());
                cartaoAprovado.setLimiteAprovado(limiteAprovado);

                return cartaoAprovado;
            }).collect(Collectors.toList());

            return new RetornoAvaliacaoCliente(listaCartoesAprovados);

        }catch(FeignException.FeignClientException e) {
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException("Dados do cliente não encontrado para o CPF informado");
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }
}
