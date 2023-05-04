package com.edwborges.controllers;

import com.edwborges.dtos.request.CartaoRequest;
import com.edwborges.dtos.response.CartaoResponse;
import com.edwborges.dtos.response.CartoesPorClienteResponse;
import com.edwborges.models.ClienteCartao;
import com.edwborges.services.CartaoService;
import com.edwborges.services.ClienteCartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cartao")
public class CartaoController {

    private final CartaoService cartaoService;

    private final ClienteCartaoService clienteCartaoService;

    public CartaoController(CartaoService cartaoService, ClienteCartaoService clienteCartaoService) {
        this.cartaoService = cartaoService;
        this.clienteCartaoService = clienteCartaoService;
    }

    @PostMapping
    public ResponseEntity<CartaoResponse> cadastra( @RequestBody CartaoRequest cartaoRequest ){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoService.salvar(cartaoRequest));
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<CartaoResponse>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.buscarCartoesRendaMenorIgual(renda));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> lista = clienteCartaoService.listaCartoesPorCpf(cpf);
        List<CartoesPorClienteResponse> resultList = lista.stream()
                .map(CartoesPorClienteResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
