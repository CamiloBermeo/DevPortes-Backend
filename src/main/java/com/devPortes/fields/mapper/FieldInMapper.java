package com.devPortes.fields.mapper;

import com.devPortes.fields.dto.FieldsCompleteResponseDto;
import com.devPortes.fields.model.Field;

import java.util.List;

public class FieldInMapper {
    public static FieldsCompleteResponseDto toFieldsCompleteResponseDto (Field model){

       return null;

    }

    public static List<FieldsCompleteResponseDto> toFieldsCompleteResponseDtoList(List<Field> models){
        return models.stream().map(FieldInMapper::toFieldsCompleteResponseDto)
                .toList();
    }
}
