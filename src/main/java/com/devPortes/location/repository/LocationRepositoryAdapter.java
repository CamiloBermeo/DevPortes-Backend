package com.devPortes.location.repository;

import com.devPortes.location.entities.LocationEntity;
import com.devPortes.location.mapper.LocationOutMapper;
import com.devPortes.location.model.Location;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryAdapter {

    private final LocationJpaRepository jpa;

    public Optional<Location> findByName(String name){
        Optional<LocationEntity> entity = jpa.findByName(name);
        return entity.map(LocationOutMapper::toModel);
    }

    @Transactional
    public Location save (Location locationModel){
        LocationEntity entity = LocationOutMapper.toEntity(locationModel);
        return LocationOutMapper.toModel(jpa.save(entity));
    }
    public Optional<Location> findById(Long id){
        Optional<LocationEntity> entity = jpa.findById(id);
        return entity.map(LocationOutMapper::toModel);
    }

    public List<Location> findAll(){
        return LocationOutMapper.toModelList(jpa.findAll());
    }
}
