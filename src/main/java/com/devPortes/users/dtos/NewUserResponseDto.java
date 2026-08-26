package com.devPortes.users.dtos;

public record NewUserResponseDto(
        Long id,
        String nameUser,
        String email,
        String token
) {
}
