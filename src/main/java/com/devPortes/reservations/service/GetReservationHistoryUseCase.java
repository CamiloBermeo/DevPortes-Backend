package com.devPortes.reservations.service;

import com.devPortes.reservations.dto.ReservationSummaryResponseDto;
import com.devPortes.reservations.model.EstadoReservationEnum;
import com.devPortes.reservations.model.Reservation;
import com.devPortes.reservations.repository.ReservationJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetReservationHistoryUseCase implements IGetReservationHistoryUseCase {

    private final ReservationJpaRepositoryAdapter repository;

    @Override
    public List<ReservationSummaryResponseDto> execute(Long userId) {
        List<Reservation> reservations = repository.findAllByUserId(userId).stream()
                .filter(r -> r.getState() != EstadoReservationEnum.PENDIENTE)
                .toList();
        return reservations.stream()
                .map(r -> new ReservationSummaryResponseDto(
                        r.getId(),
                        r.getField().getName(),
                        r.getReservationDate().toString(),
                        r.getStartTime().toString(),
                        "Individual",
                        r.getState().name()
                ))
                .toList();
    }
}
