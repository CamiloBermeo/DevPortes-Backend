package com.devPortes.reservations.model;

import com.devPortes.fields.model.Field;
import com.devPortes.payments.model.PaymentMethod;
import com.devPortes.reservations.entities.EstadoReservationEnum;
import com.devPortes.users.model.UserModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {

    private Long id;
    private UserModel user;
    private Field field;
    private LocalDateTime reservationDate;
    private LocalTime  startTime;
    private LocalTime endTime;
    private int totalHours;
    private BigDecimal totalPay;
    private BigDecimal remainingPayment;
    private EstadoReservationEnum state;

    public Reservation(){
    }

    public Reservation(Long id, UserModel user, Field field, LocalDateTime reservationDate, LocalTime startTime, LocalTime endTime, int totalHours, BigDecimal totalPay,BigDecimal remainingPayment,  EstadoReservationEnum state) {
        this.id = id;
        this.user = user;
        this.field = field;
        this.reservationDate = reservationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalHours = totalHours;
        this.totalPay = totalPay;
        this.remainingPayment=remainingPayment;
        this.state = state;
    }

    public Reservation create (UserModel user,Field field, LocalDateTime reservationDate, LocalTime startTime, LocalTime endTime, int totalHours, BigDecimal totalPay, BigDecimal remainingPayment, EstadoReservationEnum state){


        return new Reservation(null,user, field,  reservationDate, startTime, endTime, totalHours, totalPay, remainingPayment, state);
    }
    public Reservation reconstitute(Long id,UserModel user, Field field,  LocalDateTime reservationDate, LocalTime startTime, LocalTime endTime, int totalHours, BigDecimal totalPay, BigDecimal remainingPayment, EstadoReservationEnum state){
        return new Reservation (id, user,field,reservationDate, startTime, endTime, totalHours, totalPay, remainingPayment, state);
    }

    public Long getId() {
        return id;
    }


    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public UserModel getUser() {
        return user;
    }

    public Field getField() {
        return field;
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

    public BigDecimal getRemainingPayment() {
        return remainingPayment;
    }

    public EstadoReservationEnum getState() {
        return state;
    }
}