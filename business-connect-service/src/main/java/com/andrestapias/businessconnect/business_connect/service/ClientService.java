package com.andrestapias.businessconnect.business_connect.service;

import com.andrestapias.businessconnect.business_connect.dto.ClientCreateDTO;
import com.andrestapias.businessconnect.business_connect.dto.ClientResponseDTO;

import java.util.List;

public interface ClientService {

    // Crear un nuevo cliente a partir de los datos de entrada
    ClientResponseDTO createClient(ClientCreateDTO clientDTO);

    // Listar todos los clientes existentes
    List<ClientResponseDTO> getAllClients();

    // Buscar un cliente por su ID
    ClientResponseDTO getClientById(Long id);

    // Eliminar un cliente por su ID
    void deleteClientById(Long id);
}

