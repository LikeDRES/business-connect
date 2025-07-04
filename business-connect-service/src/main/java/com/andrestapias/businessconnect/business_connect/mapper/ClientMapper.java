package com.andrestapias.businessconnect.business_connect.mapper;

import com.andrestapias.businessconnect.business_connect.dto.ClientCreateDTO;
import com.andrestapias.businessconnect.business_connect.dto.ClientResponseDTO;
import com.andrestapias.businessconnect.business_connect.model.Client;

public class ClientMapper {

    // Convierte de DTO de creación a entidad
    public static Client toEntity(ClientCreateDTO dto) {
        if (dto == null) return null;

        return Client.builder()
                .firstname(dto.getFirstName())
                .lastname(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }

    // Convierte de entidad a DTO de respuesta
    public static ClientResponseDTO toResponseDTO(Client client) {
        if (client == null) return null;

        return ClientResponseDTO.builder()
                .id(client.getId()) // ← importante para la respuesta
                .firstName(client.getFirstname())
                .lastName(client.getLastname())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }
}
