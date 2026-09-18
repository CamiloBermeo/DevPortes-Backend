package com.devPortes.reservations.service;

import com.devPortes.reservations.dto.AvailableDatesTimesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AvailableDatesTimesUseCase implements IAvailableDatesTimesUseCase{
    @Override
    public AvailableDatesTimesResponseDto execute(LocalDate date) {
        return null;
    }
}
