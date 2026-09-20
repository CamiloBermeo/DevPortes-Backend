package com.devPortes.reservations.dto;

public record ReservationSummaryResponseDto(
        Long id,
        String fieldName,
        String date,
        String startTime,
        String matchType,
        String status
) {
}
