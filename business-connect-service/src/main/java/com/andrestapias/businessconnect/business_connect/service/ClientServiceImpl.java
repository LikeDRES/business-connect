package com.andrestapias.businessconnect.business_connect.service;

import com.andrestapias.businessconnect.business_connect.dto.ClientDTO;
import com.andrestapias.businessconnect.business_connect.model.Client;
import com.andrestapias.businessconnect.business_connect.mapper.ClientMapper;
import com.andrestapias.businessconnect.business_connect.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.toDTO(savedClient);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(ClientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client with id " + id + " not found"));
        return ClientMapper.toDTO(client);
    }

    @Override
    public void deleteClientById(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new RuntimeException("Client with id " + id + " not found");
        }
        clientRepository.deleteById(id);
    }
}