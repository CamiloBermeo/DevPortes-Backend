package com.devPortes.fields.repository;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.exceptions.FindRepositoryNotFoundException;
import com.devPortes.fields.mapper.FieldOutMapper;
import com.devPortes.fields.model.Field;
import com.devPortes.location.entities.LocationEntity;
import com.devPortes.location.repository.ILocationJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FieldJpaRepositoryAdapter {
    private  final IFieldJpaRepository jpa;
    private final ILocationJpaRepository locationJpa;

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
