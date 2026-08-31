package com.devPortes.location.controller;

import com.devPortes.location.dto.ListLocationsResponseDto;
import com.devPortes.location.dto.NewLocationRequestDto;
import com.devPortes.location.dto.LocationCompleteResponseDto;
import com.devPortes.location.dto.NewLocationResponseDto;
import com.devPortes.location.service.ListLocationsUseCase;
import com.devPortes.location.service.NewLocationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/location")
@RequiredArgsConstructor
public class LocationController {
    private final NewLocationUseCase newLocationUseCase;
    private final ListLocationsUseCase listLocationsUseCase;

    @PostMapping("new-location")
    public ResponseEntity<NewLocationResponseDto> newLocation (@Valid @RequestBody NewLocationRequestDto dto){
        NewLocationResponseDto response = newLocationUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("locations")
    public ResponseEntity<ListLocationsResponseDto> listLocation(){
        ListLocationsResponseDto location = listLocationsUseCase.execute();
        return ResponseEntity.ok().body(location);
    }



}
