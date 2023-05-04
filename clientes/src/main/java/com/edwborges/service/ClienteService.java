package com.edwborges.service;

import com.edwborges.dto.AtualizarClienteRequest;
import com.edwborges.dto.ClienteRequest;
import com.edwborges.dto.ClienteResponse;
import com.edwborges.exceptions.EntityNotFoundException;
import com.edwborges.mapper.request.ClienteRequestMapper;
import com.edwborges.mapper.response.ClienteResponseMapper;
import com.edwborges.model.Cliente;
import com.edwborges.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponse salvar(ClienteRequest clienteRequest) {
        var cpfExistente = clienteRepository.findByCpf(clienteRequest.cpf());

        if(cpfExistente.isPresent() && !cpfExistente.get().getStatus()) {
            return ClienteResponseMapper.INSTANCE.entityToDTO(alterarStatus(cpfExistente.get()));
        }

        if(cpfExistente.isPresent() ) {
            throw new EntityNotFoundException("Cliente com o CPF: " + clienteRequest.cpf() + " já está cadastrado.");
        }
            Cliente cliente = ClienteRequestMapper.INSTANCE.dtoToEntity(clienteRequest);
            cliente.setStatus(true);
            clienteRepository.save(cliente);
            return ClienteResponseMapper.INSTANCE.entityToDTO(cliente);
    }

    public ClienteResponse buscarPorCPF(String cpf) {
        Optional<Cliente> cpfCliente = clienteRepository.findByCpf(cpf);

        if(cpfCliente.isPresent() && cpfCliente.get().getStatus().equals(true)) {
            return ClienteResponseMapper.INSTANCE.entityToDTO(cpfCliente.get());
        }

        throw new EntityNotFoundException("Cliente com cpf: " + cpf + " não cadastrado.");
    }

    public ClienteResponse editar(Long clienteId, AtualizarClienteRequest atualizarClienteRequest) {
        var cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new EntityNotFoundException("Usuario com id: " + clienteId + " não cadastrado."));

        cliente.setNome(atualizarClienteRequest.nome());
        clienteRepository.save(cliente);
        return ClienteResponseMapper.INSTANCE.entityToDTO(cliente);
    }

    public void deleteLogico(Long clienteId) {
        var cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new EntityNotFoundException("Usuario com id: " + clienteId + " não encontrado."));
        cliente.setStatus(false);
        clienteRepository.save(cliente);
    }

    protected Cliente alterarStatus(Cliente cliente) {
        cliente.setStatus(!cliente.getStatus());
        return clienteRepository.save(cliente);
    }
}
