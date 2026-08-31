package com.devPortes.fields.controller;

import com.devPortes.fields.dto.FieldsCompleteResponseDto;
import com.devPortes.fields.dto.NewFieldResponseDto;
import com.devPortes.fields.service.AllFieldsUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/field")
public class FieldController {
    private final AllFieldsUseCase allFieldsUseCase;

    @PostMapping("new-field")
    public ResponseEntity<NewFieldResponseDto> newField(@Valid @RequestBody NewFieldRequestDto dto){

    }

    @GetMapping("fields")
    public ResponseEntity<List<FieldsCompleteResponseDto>> allFields(){
        //falta completar el dto de respuesta
        List<FieldsCompleteResponseDto> fields = allFieldsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(fields);
    }

}
