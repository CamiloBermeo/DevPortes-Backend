package com.devPortes.location.service;

import com.devPortes.location.dto.NewLocationRequestDto;
import com.devPortes.location.dto.NewLocationResponseDto;
import com.devPortes.location.exceptions.ExistingLocationDataBaseException;
import com.devPortes.location.mapper.LocationInMapper;
import com.devPortes.location.model.Location;
import com.devPortes.location.repository.LocationRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewLocationUseCase {
    private final LocationRepositoryImpl locationRepositoryImpl;

    public NewLocationResponseDto execute (NewLocationRequestDto dto){
        Location location = LocationInMapper.toModel(dto);

        locationRepositoryImpl.findByName(location.getName())
                .ifPresent(dbLocation ->{
                    throw new ExistingLocationDataBaseException(dbLocation.getName());});

        Location saveLocation = locationRepositoryImpl.save(location);
    return LocationInMapper.toNewLocationDto(saveLocation);
    }

}
