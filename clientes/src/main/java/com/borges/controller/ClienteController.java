package com.borges.controller;

import com.borges.dto.AtualizarClienteRequest;
import com.borges.dto.ClienteRequest;
import com.borges.dto.ClienteResponse;
import com.borges.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> salvar(@RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(clienteRequest));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscarPorCpf(@PathVariable(value = "cpf") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorCPF(cpf));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponse> editar(@PathVariable(value = "id") Long clienteId,
                                                  @RequestBody AtualizarClienteRequest atualizarClienteRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.editar(clienteId, atualizarClienteRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogico(@PathVariable(value = "id") Long clienteId) {
        clienteService.deleteLogico(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
