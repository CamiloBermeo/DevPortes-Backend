package com.devPortes.reservations.repository;

import com.devPortes.reservations.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {
}
