package com.devPortes.fields.dto;

import com.devPortes.fields.model.FieldStateEnum;
import com.devPortes.location.model.Location;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public record NewFieldRequestDto(

        Long locationId,
        MultipartFile img,
        String name,
        String capacity,
        String sport,
        String surface,
        String description,
        List<String> details,
        BigDecimal hourlyRate

) {
}
