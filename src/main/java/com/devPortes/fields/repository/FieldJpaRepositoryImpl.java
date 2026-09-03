package com.devPortes.fields.repository;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.exceptions.FindRepositoryNotFoundException;
import com.devPortes.fields.mapper.FieldOutMapper;
import com.devPortes.fields.model.Field;
import com.devPortes.location.entities.LocationEntity;
import com.devPortes.location.repository.LocationJpaRepository;
import com.devPortes.location.repository.LocationRepositoryImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FieldJpaRepositoryImpl{
    private  final FieldJpaRepository jpa;
    private final LocationJpaRepository locationJpa;

    public List<Field> findAll(){
        List<FieldEntity> saveFields = jpa.findAll();
        return FieldOutMapper.toModelList(saveFields);
    }

    @Transactional
    public Field save(Field model){
        LocationEntity locationEntity = locationJpa.findById(model.getLocation().getId())
                .orElseThrow(() -> new FindRepositoryNotFoundException(model.getLocation().getId()));

        FieldEntity entity = FieldOutMapper.toEntity(model, locationEntity);
        return FieldOutMapper.toModel(jpa.save(entity));
    }

}
