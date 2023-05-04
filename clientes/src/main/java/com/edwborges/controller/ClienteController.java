package com.edwborges.controller;

import com.edwborges.dto.AtualizarClienteRequest;
import com.edwborges.dto.ClienteRequest;
import com.edwborges.dto.ClienteResponse;
import com.edwborges.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> salvar(@RequestBody @Validated ClienteRequest clienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(clienteRequest));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<ClienteResponse> buscarPorCpf(@RequestParam(value = "cpf") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorCPF(cpf));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponse> editar(@PathVariable(value = "id") Long clienteId,
                                                  @RequestBody @Validated AtualizarClienteRequest atualizarClienteRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.editar(clienteId, atualizarClienteRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogico(@PathVariable(value = "id") Long clienteId) {
        clienteService.deleteLogico(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
