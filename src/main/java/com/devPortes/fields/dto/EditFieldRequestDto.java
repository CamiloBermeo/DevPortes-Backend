package com.devPortes.fields.dto;

import com.devPortes.fields.model.FieldStateEnum;

import java.math.BigDecimal;
import java.util.List;

public record EditFieldRequestDto(
        Long locationId,
        List<String> urlPictures,
        String name,
        String capacity,
        String sport,
        String surface,
        String description,
        List<String> details,
        BigDecimal hourlyRate,
        FieldStateEnum state
) {
}
