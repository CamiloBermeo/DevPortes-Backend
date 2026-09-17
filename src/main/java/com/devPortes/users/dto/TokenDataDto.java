package com.devPortes.users.dto;

public record TokenDataDto(
        String token,
        String nameUser,
        String email,
        String identityDocument,
        String phoneNumber
) {
}
