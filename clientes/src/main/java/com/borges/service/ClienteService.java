package com.borges.service;

import com.borges.dto.AtualizarClienteRequest;
import com.borges.dto.ClienteRequest;
import com.borges.dto.ClienteResponse;
import com.borges.exceptions.EntityNotFoundException;
import com.borges.mapper.request.ClienteRequestMapper;
import com.borges.mapper.response.ClienteResponseMapper;
import com.borges.model.Cliente;
import com.borges.repository.ClienteRepository;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponse salvar(ClienteRequest clienteRequest) {
        var cpfExiste = clienteRepository.findByCpf(clienteRequest.cpf());
        if(cpfExiste.isPresent()) {
            throw new EntityNotFoundException("Cliente com o CPF: " + clienteRequest.cpf() + " já está cadastrado.");
        }
        Cliente cliente = ClienteRequestMapper.INSTANCE.dtoToEntity(clienteRequest);
        cliente.setStatus(true);
        clienteRepository.save(cliente);
        return ClienteResponseMapper.INSTANCE.entityToDTO(cliente);
    }

    public ClienteResponse buscarPorCPF(String cpf) {
        var cpfCliente = clienteRepository.findByCpf(cpf).orElseThrow(
                () -> new EntityNotFoundException("Cliente com cpf: " + cpf + " não cadastrado."));
        return ClienteResponseMapper.INSTANCE.entityToDTO(cpfCliente);
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
}
