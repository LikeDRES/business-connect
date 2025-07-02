package com.andrestapias.businessconnect.business_connect.service;

import com.andrestapias.businessconnect.business_connect.dto.ClientDTO;
import java.util.List;

public interface ClientService {

    //Creará un nuevo cliente
    ClientDTO createClient(ClientDTO clientDTO);

    //Listar todos los clientes
    List<ClientDTO> getAllClients();

    //Buscar cliente por ID
    ClientDTO getClientById(Long id);

    //Va a eliminar al cliente por ID
    void deleteClientById(Long id);
}
