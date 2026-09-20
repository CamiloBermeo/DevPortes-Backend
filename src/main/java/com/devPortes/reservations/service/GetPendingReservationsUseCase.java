package com.devPortes.reservations.service;

import com.devPortes.reservations.dto.ReservationSummaryResponseDto;
import com.devPortes.reservations.model.Reservation;
import com.devPortes.reservations.repository.ReservationJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPendingReservationsUseCase implements IGetPendingReservationsUseCase {

    private final ReservationJpaRepositoryAdapter repository;

    @Override
    public List<ReservationSummaryResponseDto> execute(Long userId) {
        List<Reservation> reservations = repository.findPendingByUserId(userId);
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
