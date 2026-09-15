package com.devPortes.location.dto;

public record LocationCompleteResponseDto(
        Long id,
        String name,
        String headquarters,
        String address,
        String urlQrAddress,
        String description,
        boolean state
) {
}
