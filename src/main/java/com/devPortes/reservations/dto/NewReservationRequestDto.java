package com.devPortes.reservations.dto;

import com.devPortes.fields.model.Field;
import com.devPortes.payments.model.Payment;
import com.devPortes.reservations.entities.EstadoReservationEnum;
import com.devPortes.users.model.Client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record NewReservationRequestDto(
        Long userId,
        Long fieldId,
        Long paymentId,
        LocalDate reservationDate,
        LocalTime startTime,
        LocalTime endTime,
        int totalHours,
        BigDecimal totalPay,
        BigDecimal remainingPayment

) {
}
