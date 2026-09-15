package com.devPortes.fields.repository;

import com.devPortes.fields.entities.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldJpaRepository extends JpaRepository<FieldEntity, Long> {


}
