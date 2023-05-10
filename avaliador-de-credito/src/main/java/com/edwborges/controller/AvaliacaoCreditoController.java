package com.edwborges.controller;

import com.edwborges.dtos.DadosAvaliacao;
import com.edwborges.dtos.RetornoAvaliacaoCliente;
import com.edwborges.dtos.SituacaoCliente;
import com.edwborges.exceptions.DadosClienteNotFoundException;
import com.edwborges.exceptions.ErroComunicacaoMicroservicesException;
import com.edwborges.service.AvaliacaoCreditoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avaliacoes-credito")
public class AvaliacaoCreditoController {

    private final AvaliacaoCreditoService avaliacaoCreditoService;

    public AvaliacaoCreditoController(AvaliacaoCreditoService avaliacaoCreditoService) {
        this.avaliacaoCreditoService = avaliacaoCreditoService;
    }

    @GetMapping(value = "/situacao-cliente", params = "cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf) {
        try {
           SituacaoCliente situacaoCliente = avaliacaoCreditoService.obterSituacaoCliente(cpf);
           return ResponseEntity.status(HttpStatus.OK).body(situacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao) {
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliacaoCreditoService.realizarAvaliacao(dadosAvaliacao.getCpf(), dadosAvaliacao.getRenda());
            return ResponseEntity.status(HttpStatus.OK).body(retornoAvaliacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

}
