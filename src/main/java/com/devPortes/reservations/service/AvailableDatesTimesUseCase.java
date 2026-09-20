package com.devPortes.reservations.service;

import com.devPortes.reservations.dto.AvailableDatesTimesResponseDto;
import com.devPortes.reservations.mapper.ReservationInMapper;
import com.devPortes.reservations.model.Reservation;
import com.devPortes.reservations.repository.ReservationJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDatesTimesUseCase implements IAvailableDatesTimesUseCase {

    private final ReservationJpaRepositoryAdapter repository;

    @Override
    public AvailableDatesTimesResponseDto execute(LocalDate date) {

        List<Reservation> reservations = repository.findByReservationDate(date);

        List<LocalTime> hours = new ArrayList<>();
        for (Reservation reservation : reservations) {
            hours.add(reservation.getStartTime());
        }
        return ReservationInMapper.toAvailableDatesTimesResponseDto(hours);
    }
}
