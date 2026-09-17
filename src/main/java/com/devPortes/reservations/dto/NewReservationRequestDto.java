package com.devPortes.reservations.dto;

public record NewReservationRequestDto(
        Long userId,
        Long fieldId,
        Long paymentId,

) {
}
