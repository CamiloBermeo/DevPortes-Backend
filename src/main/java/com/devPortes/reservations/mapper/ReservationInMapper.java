package com.devPortes.reservations.mapper;

import com.devPortes.reservations.dto.AvailableDatesTimesResponseDto;

import java.time.LocalTime;
import java.util.List;

public class ReservationInMapper {
    public static AvailableDatesTimesResponseDto toAvailableDatesTimesResponseDto(List<LocalTime> hours){
        return new AvailableDatesTimesResponseDto(hours);
    }

}
