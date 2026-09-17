package com.devPortes.reservations.service;

import com.devPortes.reservations.dto.NewReservationRequestDto;
import com.devPortes.reservations.dto.NewReservationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewReservationUseCase implements INewReservationUseCase{
    private final ReservationJpaRepositoryAdapter repository;

    @Override
    public NewReservationResponseDto execute(NewReservationRequestDto dto) {




        return null;
    }
}
