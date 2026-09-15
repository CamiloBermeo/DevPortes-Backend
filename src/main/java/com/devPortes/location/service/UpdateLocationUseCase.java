package com.devPortes.location.service;

import com.devPortes.location.dto.LocationCompleteResponseDto;
import com.devPortes.location.dto.UpdateLocationRequestDto;
import com.devPortes.location.exceptions.ExistingLocationDataBaseException;
import com.devPortes.location.exceptions.LocationNotFoundException;
import com.devPortes.location.mapper.LocationInMapper;
import com.devPortes.location.model.Location;
import com.devPortes.location.repository.LocationRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateLocationUseCase implements IUpdateLocationUseCase {
    private final LocationRepositoryAdapter locationRepositoryAdapter;

    @Override
    public LocationCompleteResponseDto execute(Long id, UpdateLocationRequestDto dto) {
        Location existingLocation = locationRepositoryAdapter.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

        Location editedLocation = LocationInMapper.toEditModel(dto);

        if (!existingLocation.getName().equals(editedLocation.getName())) {
            locationRepositoryAdapter.findByName(editedLocation.getName())
                    .ifPresent(dbLocation -> {
                        throw new ExistingLocationDataBaseException(dbLocation.getName());
                    });
        }

        Location savedLocation = locationRepositoryAdapter.editLocation(editedLocation, id);
        return LocationInMapper.toLocationCompleteDto(savedLocation);
    }
}
