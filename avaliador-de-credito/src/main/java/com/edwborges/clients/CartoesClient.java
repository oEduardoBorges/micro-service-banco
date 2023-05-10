package com.edwborges.clients;

import com.edwborges.dtos.cartao.CartaoCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cartoes-service", path = "/api/cartao")
public interface CartoesClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CartaoCliente>> getCartoesPorCliente(@RequestParam("cpf") String cpf);

    @GetMapping(params = "renda")
    ResponseEntity<List<CartaoCliente>> getCartoesRendaAte(@RequestParam("renda") Long renda);
}
