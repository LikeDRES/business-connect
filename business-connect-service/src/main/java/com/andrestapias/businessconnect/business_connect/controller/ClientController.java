package com.andrestapias.businessconnect.business_connect.controller;

import com.andrestapias.businessconnect.business_connect.dto.ClientDTO;
import com.andrestapias.businessconnect.business_connect.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //Crear Cliente
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientDTO clientDTO) {
        ClientDTO created = clientService.createClient(clientDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    //Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    //Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    //Eliminar cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }
}
