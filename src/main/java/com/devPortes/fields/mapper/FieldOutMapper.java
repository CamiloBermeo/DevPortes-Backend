package com.devPortes.fields.mapper;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.model.Field;

import java.util.List;
import java.util.stream.Collectors;

public class FieldOutMapper {

    public static Field toModel (FieldEntity entity){
        return Field.reconstitute(
                entity.getId(),
                entity.getUrlImg(),
                entity.getName(),
                entity.getCapacity(),
                entity.getCategory(),
                entity.getDescription(),
                entity.getDetails(),
                entity.getHourlyRate(),
                entity.isState()

        );
    }

    public static List<Field> toModelList(List<FieldEntity> fieldsEntity){
        return fieldsEntity.stream().map(FieldOutMapper::toModel)
                .collect(Collectors.toList());
    }

}
