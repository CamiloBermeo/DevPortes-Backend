package com.devPortes.fields.dto;

import java.math.BigDecimal;
import java.util.List;

public record FieldsCompleteResponseDto(

        String urlImg,
        String name,
        String category,
        String description,
        List<String> details

) {
}
