package com.edwborges.clients;

import com.edwborges.dtos.cliente.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "clientes-service", path = "/api/clientes")
public interface ClienteClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> buscarPorCpf(@RequestParam(value = "cpf") String cpf);
}
