package com.devPortes.fields.repository;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.exceptions.FieldRepositoryNotFoundException;
import com.devPortes.fields.mapper.FieldOutMapper;
import com.devPortes.fields.model.Field;
import com.devPortes.location.entities.LocationEntity;
import com.devPortes.location.exceptions.LocationNotFoundException;
import com.devPortes.location.exceptions.LocationRepositoryNotFoundException;
import com.devPortes.location.repository.ILocationJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FieldJpaRepositoryAdapter {
    private final IFieldJpaRepository jpa;
    private final ILocationJpaRepository locationJpa;

    public List<Field> findAll() {
        List<FieldEntity> saveFields = jpa.findAll();
        return FieldOutMapper.toModelList(saveFields);
    }

    @Transactional
    public Field save(Field model) {
        LocationEntity locationEntity = locationJpa.findById(model.getLocation().getId())
                .orElseThrow(() -> new LocationRepositoryNotFoundException(model.getLocation().getId()));

        FieldEntity entity = FieldOutMapper.toEntity(model, locationEntity);
        return FieldOutMapper.toModel(jpa.save(entity));
    }
    @Transactional
    public Optional<Field> findById(Long id) {
        Optional<FieldEntity> saveEntity = jpa.findById(id);
        return saveEntity.map(FieldOutMapper::toModel);
    }

    @Transactional
    public Field editField(Field fieldModelEdit, Long id ) {
        FieldEntity fieldSaveEntity = jpa.findById(id)
                .orElseThrow(()-> new FieldRepositoryNotFoundException(id));
        LocationEntity locationEntity = locationJpa.findById(fieldModelEdit.getLocation().getId())
                .orElseThrow(() -> new LocationRepositoryNotFoundException(fieldModelEdit.getLocation().getId()));

        //nueva entidad a guardar
        FieldEntity editEntity = FieldOutMapper.toEditEntity(fieldSaveEntity, locationEntity, fieldModelEdit);
        //guardo la entidad editada
        FieldEntity saveFieldEdit = jpa.save(editEntity);

        return FieldOutMapper.toModel(saveFieldEdit);
    }
}
