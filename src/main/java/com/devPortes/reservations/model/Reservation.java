package com.devPortes.reservations.model;

import com.devPortes.payments.model.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {

    private Long id;
    private PaymentMethod paymentMethod;
    private LocalDateTime reservationDate;
    private LocalTime  startTime;
    private LocalTime endTime;
    private int totalHours;
    private BigDecimal totalPay;
    private String reservationCode;
    private boolean state;

    public Reservation() {
    }

    public Reservation(Long id, PaymentMethod paymentMethod, LocalDateTime reservationDate, LocalTime startTime, LocalTime endTime, int totalHours, BigDecimal totalPay, String reservationCode, boolean state) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.reservationDate = reservationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalHours = totalHours;
        this.totalPay = totalPay;
        this.reservationCode = reservationCode;
        this.state = state;
    }

    public Reservation create (PaymentMethod paymentMethod, LocalDateTime reservationDate, LocalTime startTime, LocalTime endTime, int totalHours, BigDecimal totalPay, String reservationCode, boolean state){
        return new Reservation(null, paymentMethod, reservationDate, startTime, endTime, totalHours, totalPay, reservationCode, state);
    }
    public Reservation reconstitute(Long id, PaymentMethod paymentMethod, LocalDateTime reservationDate, LocalTime startTime, LocalTime endTime, int totalHours, BigDecimal totalPay, String reservationCode, boolean state){
        return new Reservation (id, paymentMethod, reservationDate, startTime, endTime, totalHours, totalPay, reservationCode, state);
    }

    public Long getId() {
        return id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public boolean isState() {
        return state;
    }
}