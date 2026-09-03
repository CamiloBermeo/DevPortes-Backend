package com.devPortes.fields.mapper;

import com.devPortes.fields.dto.FieldsCompleteResponseDto;
import com.devPortes.fields.dto.NewFieldRequestDto;
import com.devPortes.fields.model.Field;
import com.devPortes.fields.model.FieldStateEnum;
import com.devPortes.location.model.Location;

import java.math.BigDecimal;
import java.util.List;

public class FieldInMapper {
    public static Field toModel(NewFieldRequestDto dto, Location location, String urlImg){
        return Field.create(
                location,
                urlImg,
                dto.name(),
                dto.capacity(),
                dto.sport(),
                dto.surface(),
                dto.description(),
                dto.details(),
                dto.hourlyRate()
        );
    }
    public static FieldsCompleteResponseDto toFieldsCompleteResponseDto (Field model){
       return new FieldsCompleteResponseDto(
               model.getId(),
               model.getLocation().getId(),
               model.getUrlImg(),
               model.getName(),
               model.getCapacity(),
               model.getSport(),
               model.getSurface(),
               model.getDescription(),
               model.getDetails(),
               model.getHourlyRate(),
               model.getState()
       );

    }

    public static List<FieldsCompleteResponseDto> toFieldsCompleteResponseDtoList(List<Field> models){
        return models.stream().map(FieldInMapper::toFieldsCompleteResponseDto)
                .toList();
    }
}
