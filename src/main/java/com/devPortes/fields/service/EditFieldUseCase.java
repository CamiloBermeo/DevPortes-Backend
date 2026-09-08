package com.devPortes.fields.service;

import com.devPortes.fields.dto.EditFieldRequestDto;
import com.devPortes.fields.dto.FieldsCompleteResponseDto;
import com.devPortes.fields.exceptions.FieldNotFoundException;
import com.devPortes.fields.exceptions.FieldRepositoryNotFoundException;
import com.devPortes.fields.mapper.FieldInMapper;
import com.devPortes.fields.model.Field;
import com.devPortes.fields.repository.FieldJpaRepositoryAdapter;
import com.devPortes.location.exceptions.LocationNotFoundException;
import com.devPortes.location.model.Location;
import com.devPortes.location.service.IFindLocationByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditFieldUseCase implements IEditFieldUseCase{
    private final FieldJpaRepositoryAdapter fieldRepository;
    private final IFindLocationByIdUseCase iFindLocationById;


    @Override
    public FieldsCompleteResponseDto execute(Long id, EditFieldRequestDto dto) {
        //Busco la cancha por el id
        Field saveField = fieldRepository.findById(id)
                .orElseThrow(() -> new FieldNotFoundException(id));
        //reviso que la location tambien exista
        Location location = iFindLocationById.execute(dto.locationId())
                .orElseThrow(()-> new LocationNotFoundException(dto.locationId()));

        //reemplazo los datos
        Field editField = FieldInMapper.toEditModel(dto, location);

        //Guardo los nuevos datos y retorno la cancha guardada
        return FieldInMapper.toFieldsCompleteResponseDto(fieldRepository.editField(editField, id));
    }
}
