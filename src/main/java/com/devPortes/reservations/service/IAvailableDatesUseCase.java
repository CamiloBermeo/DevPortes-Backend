package com.devPortes.reservations.service;

import com.devPortes.reservations.dto.AvailableDatesResponseDto;

public interface IAvailableDatesUseCase {

    AvailableDatesResponseDto execute(int year, int month);

}
