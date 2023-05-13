package com.edwborges.controller;

import com.edwborges.dtos.DadosSolicitacaoEmissaoCartao;
import com.edwborges.dtos.ProtocoloSolicitacaoCartao;
import com.edwborges.exceptions.ErroSolicitacaoCartaoException;
import com.edwborges.service.AvaliacaoCreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solicitacao-cartao")
public class SolicitacaoCartaoController {

    private final AvaliacaoCreditoService avaliacaoCreditoService;

    public SolicitacaoCartaoController(AvaliacaoCreditoService avaliacaoCreditoService) {
        this.avaliacaoCreditoService = avaliacaoCreditoService;
    }

    @PostMapping("/solicitacoes-cartao")
    public ResponseEntity solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao) {
        try{
            ProtocoloSolicitacaoCartao protocoloSolicitacaoCartao = avaliacaoCreditoService
                    .solicitarEmissaoCartao(dadosSolicitacaoEmissaoCartao);
            return ResponseEntity.ok(protocoloSolicitacaoCartao);
        }catch (ErroSolicitacaoCartaoException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
