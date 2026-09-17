package com.devPortes.reservations.service;

import com.devPortes.reservations.dto.AvailableDatesTimesResponseDto;

import java.time.LocalDateTime;

public interface IAvailableDatesTimesUseCase {

    AvailableDatesTimesResponseDto execute(LocalDateTime date);

}
