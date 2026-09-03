package com.devPortes.location.service;

import com.devPortes.location.model.Location;
import com.devPortes.location.repository.LocationRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindLocationByIdUseCaseUseCase implements IFindLocationByIdUseCase {
    private final LocationRepositoryImpl locationRepositoryImpl;

    @Override
    public Optional<Location> execute(Long id) {
        return locationRepositoryImpl.findById(id);
    }
}
