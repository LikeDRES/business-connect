package com.andrestapias.businessconnect.business_connect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @Email(message = "El correo no tiene un formato valido")
    private String email;

    @Size(max = 10, message = "El teléfono no puede tener más de 10 dígitos")
    private String phone;
}
