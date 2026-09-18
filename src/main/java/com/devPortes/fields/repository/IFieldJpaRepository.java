package com.devPortes.fields.repository;

import com.devPortes.fields.entities.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFieldJpaRepository extends JpaRepository<FieldEntity, Long> {
    @Override
    @Query("SELECT f FROM FieldEntity f ORDER BY f.id ASC")
    List<FieldEntity> findAll();
}
