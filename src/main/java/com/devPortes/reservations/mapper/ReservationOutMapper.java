package com.devPortes.reservations.mapper;

import com.devPortes.fields.mapper.FieldOutMapper;
import com.devPortes.payments.mapper.PaymentOutMapper;
import com.devPortes.reservations.entities.ReservationEntity;
import com.devPortes.reservations.model.Reservation;
import com.devPortes.users.mapper.UserOutMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationOutMapper {
    public static Reservation toModel(ReservationEntity reservation){
        Reservation reservationModel = new Reservation();
        return reservationModel.reconstitute(
                reservation.getId(),
                UserOutMapper.toClientCompleteModel(reservation.getClientEntity()),
                FieldOutMapper.toModel(reservation.getFieldEntity()),
                PaymentOutMapper.toModel(reservation.getPayment()),
                reservation.getReservationDate(),
                reservation.getStartTime(),
                reservation.getEndTime(),
                reservation.getTotalHours(),
                reservation.getTotalPay(),
                reservation.getRemainingPayment(),
                reservation.getState()
                );
    }
    public static List<Reservation> toModelList(List<ReservationEntity> reservations){
            return reservations.stream().map(ReservationOutMapper::toModel)
                    .collect(Collectors.toList());

    }

}
