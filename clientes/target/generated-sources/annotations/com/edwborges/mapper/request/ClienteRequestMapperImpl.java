package com.edwborges.mapper.request;

import com.edwborges.dto.ClienteRequest;
import com.edwborges.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T15:42:38-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class ClienteRequestMapperImpl implements ClienteRequestMapper {

    @Override
    public ClienteRequest entityToDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        String cpf = null;
        String nome = null;
        Integer idade = null;

        cpf = entity.getCpf();
        nome = entity.getNome();
        idade = entity.getIdade();

        ClienteRequest clienteRequest = new ClienteRequest( cpf, nome, idade );

        return clienteRequest;
    }

    @Override
    public Cliente dtoToEntity(ClienteRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCpf( dto.cpf() );
        cliente.setNome( dto.nome() );
        cliente.setIdade( dto.idade() );

        return cliente;
    }

    @Override
    public List<ClienteRequest> listEntityToListDTO(List<Cliente> lista) {
        if ( lista == null ) {
            return null;
        }

        List<ClienteRequest> list = new ArrayList<ClienteRequest>( lista.size() );
        for ( Cliente cliente : lista ) {
            list.add( entityToDTO( cliente ) );
        }

        return list;
    }
}
