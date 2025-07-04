package com.andrestapias.businessconnect.business_connect.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}