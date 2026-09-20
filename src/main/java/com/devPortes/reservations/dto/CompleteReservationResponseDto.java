package com.devPortes.reservations.dto;

import com.devPortes.reservations.model.EstadoReservationEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record CompleteReservationResponseDto(
        Long id,
        Long userId,
        Long fieldId,
        Long paymentId,
        LocalDate reservationDate,
        LocalTime startTime,
        LocalTime endTime,
        int totalHours,
        BigDecimal totalPay,
        BigDecimal remainingPayment,
        EstadoReservationEnum state
) {
}
