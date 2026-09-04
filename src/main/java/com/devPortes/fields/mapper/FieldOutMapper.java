package com.devPortes.fields.mapper;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.model.Field;
import com.devPortes.location.entities.LocationEntity;
import com.devPortes.location.mapper.LocationOutMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FieldOutMapper {

    public static FieldEntity toEntity(Field model, LocationEntity locationEntity){
        FieldEntity entity = new FieldEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setCapacity(model.getCapacity());
        entity.setSport(model.getSport());
        entity.setSurface(model.getSurface());
        entity.setDescription(model.getDescription());
        entity.setDetails(model.getDetails());
        entity.setHourlyRate(model.getHourlyRate());
        entity.setUrlImg(model.getUrlImg());
        entity.setLocation(locationEntity);
        entity.setState(model.getState());
        return entity;
    }

    public static Field toModel (FieldEntity entity){
        return Field.reconstitute(
                entity.getId(),
                LocationOutMapper.toModel(entity.getLocation()),
                entity.getUrlImg(),
                entity.getName(),
                entity.getCapacity(),
                entity.getSport(),
                entity.getSurface(),
                entity.getDescription(),
                entity.getDetails(),
                entity.getHourlyRate(),
                entity.getState()
        );
    }

    public static List<Field> toModelList(List<FieldEntity> fieldsEntity){
        return fieldsEntity.stream().map(FieldOutMapper::toModel)
                .collect(Collectors.toList());
    }

}
