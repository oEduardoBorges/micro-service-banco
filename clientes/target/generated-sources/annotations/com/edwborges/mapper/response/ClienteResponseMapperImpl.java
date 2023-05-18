package com.edwborges.mapper.response;

import com.edwborges.dto.ClienteResponse;
import com.edwborges.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T15:42:38-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class ClienteResponseMapperImpl implements ClienteResponseMapper {

    @Override
    public ClienteResponse entityToDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        Long clienteId = null;
        String cpf = null;
        String nome = null;
        Integer idade = null;

        clienteId = entity.getClienteId();
        cpf = entity.getCpf();
        nome = entity.getNome();
        idade = entity.getIdade();

        ClienteResponse clienteResponse = new ClienteResponse( clienteId, cpf, nome, idade );

        return clienteResponse;
    }

    @Override
    public Cliente dtoToEntity(ClienteResponse dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setClienteId( dto.clienteId() );
        cliente.setCpf( dto.cpf() );
        cliente.setNome( dto.nome() );
        cliente.setIdade( dto.idade() );

        return cliente;
    }

    @Override
    public List<ClienteResponse> listEntityToListDTO(List<Cliente> lista) {
        if ( lista == null ) {
            return null;
        }

        List<ClienteResponse> list = new ArrayList<ClienteResponse>( lista.size() );
        for ( Cliente cliente : lista ) {
            list.add( entityToDTO( cliente ) );
        }

        return list;
    }
}
