package com.devPortes.users.dto;

public record ListUsersResponseDto(
    Long id,
    String name,
    String email,
    String identityDocument,
    String phoneNumber,
    String role,
    String classification,
    boolean state
) {}
