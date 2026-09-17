package com.devPortes.reservations.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationJpaRepositoryAdapter {
    private final IReservationJpaRepository jpa;

}
