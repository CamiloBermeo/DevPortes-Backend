package com.devPortes.fields.service;

import com.devPortes.client.ICloudinaryClient;
import com.devPortes.fields.dto.FieldsCompleteResponseDto;
import com.devPortes.fields.dto.NewFieldRequestDto;
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
public class NewFieldUseCase implements INewFieldUseCase{
    private final ICloudinaryClient iCloudinaryClient;
    private final IFindLocationByIdUseCase iFindLocationById;
    private final FieldJpaRepositoryAdapter fieldJpaRepository;
    @Override
    public FieldsCompleteResponseDto execute(NewFieldRequestDto dto) {
        //verifico que exista la ubicacion con el id
        Location location = iFindLocationById.execute(dto.locationId())
                .orElseThrow(() -> new LocationNotFoundException(dto.locationId()));

        //guardo la imagen en cloudinary y retorno su url
        String urlImg = iCloudinaryClient.saveImg(dto.img());

        Field field = FieldInMapper.toModel(dto, location, urlImg);

        return FieldInMapper.toFieldsCompleteResponseDto(
                fieldJpaRepository.save(field));
    }
}
