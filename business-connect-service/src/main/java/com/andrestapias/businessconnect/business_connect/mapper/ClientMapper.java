package com.andrestapias.businessconnect.business_connect.mapper;

import com.andrestapias.businessconnect.business_connect.dto.ClientDTO;
import com.andrestapias.businessconnect.business_connect.model.Client;

public class ClientMapper {
    public static Client toEntity(ClientDTO dto) {
        if(dto == null) return null;

        return Client.builder()
                .firstname(dto.getFirstName())
                .lastname(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }

    public static ClientDTO toDTO(Client entity){
        if(entity == null) return null;

        return ClientDTO.builder()
                .firstName(entity.getFirstname())
                .lastName(entity.getLastname())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();
    }
}