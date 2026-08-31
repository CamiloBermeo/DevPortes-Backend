package com.devPortes.fields.repository;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.mapper.FieldOutMapper;
import com.devPortes.fields.model.Field;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FieldJpaRepositoryImpl{
    private  final FieldJpaRepository jpa;

    public List<Field> findAll(){
        List<FieldEntity> saveFields = jpa.findAll();
        return FieldOutMapper.toModelList(saveFields);
    }

}
