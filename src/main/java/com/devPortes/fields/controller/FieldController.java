package com.devPortes.fields.controller;

import com.devPortes.fields.dto.FieldsCompleteResponseDto;
import com.devPortes.fields.dto.NewFieldRequestDto;
import com.devPortes.fields.dto.NewFieldResponseDto;
import com.devPortes.fields.service.AllFieldsUseCase;
import com.devPortes.fields.service.IAllFieldsUseCase;
import com.devPortes.fields.service.INewFieldUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/field")
public class FieldController {
    private final IAllFieldsUseCase iAllFieldsUseCase;
    private final INewFieldUseCase iNewFieldUseCase;

    @PostMapping(value = "new-field", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FieldsCompleteResponseDto> newField(@Valid @ModelAttribute NewFieldRequestDto dto){
        FieldsCompleteResponseDto response = iNewFieldUseCase.execute(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("fields")
    public ResponseEntity<List<FieldsCompleteResponseDto>> allFields(){
        //falta completar el dto de respuesta
        List<FieldsCompleteResponseDto> fields = iAllFieldsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(fields);
    }

}
