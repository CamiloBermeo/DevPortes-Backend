package com.devPortes.users.repository;

import com.devPortes.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail (String email);

}
