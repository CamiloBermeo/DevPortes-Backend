package com.devPortes.reservations.repository;

import com.devPortes.reservations.entities.ReservationEntity;
import com.devPortes.reservations.mapper.ReservationOutMapper;
import com.devPortes.reservations.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationJpaRepositoryAdapter {
    private final IReservationJpaRepository jpa;

    public List<Reservation> findByReservationDate(LocalDate date){
        List<ReservationEntity> reservationEntities = jpa.findByReservationDateBetween(date);
        return ReservationOutMapper.toModelList(reservationEntities);
    }
}
