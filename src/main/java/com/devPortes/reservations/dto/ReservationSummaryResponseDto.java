package com.devPortes.reservations.dto;

public record ReservationSummaryResponseDto(
        Long id,
        String fieldName,
        String date,
        String startTime,
        String matchType,
        String status,
        String endTime,
        Integer totalHours,
        java.math.BigDecimal totalPay,
        java.math.BigDecimal remainingPayment,
        String clientName,
        String clientEmail
) {
    public ReservationSummaryResponseDto(
            Long id,
            String fieldName,
            String date,
            String startTime,
            String matchType,
            String status
    ) {
        this(id, fieldName, date, startTime, matchType, status, null, null, null, null, null, null);
    }
}
