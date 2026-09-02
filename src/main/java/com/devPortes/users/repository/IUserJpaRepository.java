package com.devPortes.users.repository;

import com.devPortes.users.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserJpaRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByEmail (String email);

}
