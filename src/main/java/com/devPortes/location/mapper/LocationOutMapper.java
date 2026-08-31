package com.devPortes.location.mapper;

import com.devPortes.location.entities.LocationEntity;
import com.devPortes.location.model.Location;

import java.util.List;

public class LocationOutMapper {

    public static LocationEntity toEntity(Location model){
        LocationEntity entity = new LocationEntity();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setHeadquarters(model.getHeadquarters());
        entity.setAddress(model.getAddress());
        entity.setUrlQrAddress(model.getUrlQrAddress());
        entity.setDescription(model.getDescription());
        entity.setState(model.isState());
        return entity;

    }
    public static Location toModel(LocationEntity entity){
        return Location.reconstitute(
                entity.getId(),
                entity.getName(),
                entity.getHeadquarters(),
                entity.getAddress(),
                entity.getUrlQrAddress(),
                entity.getDescription(),
                entity.isState()
        );
    }
    public static List<Location> toModelList(List<LocationEntity> entities){
        return entities.stream().map(LocationOutMapper::toModel)
                .toList();
    }

}
