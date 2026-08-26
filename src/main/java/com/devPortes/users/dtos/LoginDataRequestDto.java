package com.devPortes.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDataRequestDto(
        @Email(message = "Ingrese un Email valido")
        String email,
        @NotBlank(message = "Dato vacío")
        String password
) {
}
