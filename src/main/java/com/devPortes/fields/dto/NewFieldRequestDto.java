package com.devPortes.fields.dto;

import java.util.List;

public record NewFieldRequestDto(

        Long locationId,
        String urlImg,
        String name,
        String capacity,
        String sport,
        String surface,
        String description,
        List<String>details,
        String hourlyRate

) {
}
