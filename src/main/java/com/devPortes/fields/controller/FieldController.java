package com.devPortes.fields.controller;

import com.devPortes.fields.dto.EditFieldRequestDto;
import com.devPortes.fields.dto.FieldsCompleteResponseDto;
import com.devPortes.fields.dto.NewFieldRequestDto;
import com.devPortes.fields.service.IAllFieldsUseCase;
import com.devPortes.fields.service.IEditFieldUseCase;
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
    private final IEditFieldUseCase iEditField;

    @PostMapping(value = "new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FieldsCompleteResponseDto> newField(@Valid @ModelAttribute NewFieldRequestDto dto) {
        FieldsCompleteResponseDto response = iNewFieldUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<FieldsCompleteResponseDto> editField( @PathVariable Long id,
                                                                @Valid @ModelAttribute EditFieldRequestDto dto) {
        FieldsCompleteResponseDto response = iEditField.execute(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("all")
    public ResponseEntity<List<FieldsCompleteResponseDto>> allFields() {
        List<FieldsCompleteResponseDto> fields = iAllFieldsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(fields);
    }

}