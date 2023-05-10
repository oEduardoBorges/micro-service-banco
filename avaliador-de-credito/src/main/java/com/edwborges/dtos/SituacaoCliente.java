package com.edwborges.dtos;

import com.edwborges.dtos.cartao.CartaoCliente;
import com.edwborges.dtos.cliente.DadosCliente;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SituacaoCliente {

    private DadosCliente cliente;

    private List<CartaoCliente> cartoes;
}
