package com.andrestapias.businessconnect.business_connect.service;

import com.andrestapias.businessconnect.business_connect.dto.ClientCreateDTO;
import com.andrestapias.businessconnect.business_connect.dto.ClientResponseDTO;
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
    public ClientResponseDTO createClient(ClientCreateDTO clientDTO) {
        // Convertimos el DTO de entrada en entidad
        Client client = ClientMapper.toEntity(clientDTO);

        // Guardamos la entidad
        Client savedClient = clientRepository.save(client);

        // Retornamos el DTO de respuesta
        return ClientMapper.toResponseDTO(savedClient);
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client with id " + id + " not found"));
        return ClientMapper.toResponseDTO(client);
    }

    @Override
    public void deleteClientById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client with id " + id + " not found");
        }
        clientRepository.deleteById(id);
    }
}
