package com.devPortes.users.infrastructure.output.repository;

import com.devPortes.users.infrastructure.output.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail (String email);

}
