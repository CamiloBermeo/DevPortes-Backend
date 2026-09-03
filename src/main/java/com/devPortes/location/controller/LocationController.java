package com.devPortes.location.controller;

import com.devPortes.location.dto.ListLocationsResponseDto;
import com.devPortes.location.dto.NewLocationRequestDto;
import com.devPortes.location.dto.LocationCompleteResponseDto;
import com.devPortes.location.dto.NewLocationResponseDto;
import com.devPortes.location.service.IListLocationsUseCase;
import com.devPortes.location.service.INewLocationUseCase;
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
    private final INewLocationUseCase iNewLocationUseCase;
    private final IListLocationsUseCase iListLocationsUseCase;

    @PostMapping("new-location")
    public ResponseEntity<NewLocationResponseDto> newLocation (@Valid @RequestBody NewLocationRequestDto dto){
        NewLocationResponseDto response = iNewLocationUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("locations")
    public ResponseEntity<ListLocationsResponseDto> listLocation(){
        ListLocationsResponseDto location = iListLocationsUseCase.execute();
        return ResponseEntity.ok().body(location);
    }



}
