package com.devPortes.users.dto;

public record NewUserResponseDto(
        Long id,
        String nameUser,
        String email,
        String token
) {
}