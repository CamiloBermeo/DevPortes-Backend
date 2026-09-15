package com.devPortes.payments.model;

import com.devPortes.reservations.model.Reservation;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private Long id;
    private PaymentMethod paymentMethod;
    private Reservation reservation;
    private BigDecimal totalAmount;
    private LocalDateTime datePayment;
    private String referenceTransaction;
    private String notes;
    private PaymentStateEnum stateEnum;


}