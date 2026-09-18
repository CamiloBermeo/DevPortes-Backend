package com.devPortes.reservations.controller;

import com.devPortes.reservations.dto.AvailableDatesTimesResponseDto;
import com.devPortes.reservations.dto.NewReservationRequestDto;
import com.devPortes.reservations.dto.NewReservationResponseDto;
import com.devPortes.reservations.service.IAvailableDatesTimesUseCase;
import com.devPortes.reservations.service.INewReservationUseCase;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reservation")
public class ReservationController {
    private final INewReservationUseCase iNewReservationUseCase;
    private final IAvailableDatesTimesUseCase iAvailableDatesTimes;

    @PostMapping("new")
    public ResponseEntity<NewReservationResponseDto> newReservation(@Valid @RequestBody NewReservationRequestDto dto){
        NewReservationResponseDto response = iNewReservationUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("available-dates-times/{date}")
public ResponseEntity<AvailableDatesTimesResponseDto> showAvailableDatesTimes (@PathVariable LocalDate date){
        AvailableDatesTimesResponseDto response = iAvailableDatesTimes.execute(date);
        return ResponseEntity.status(HttpStatus.OK).body(response);
}
}
