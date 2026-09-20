package com.devPortes.reservations.repository;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.exceptions.FieldRepositoryNotFoundException;
import com.devPortes.fields.model.Field;
import com.devPortes.fields.repository.FieldJpaRepositoryAdapter;
import com.devPortes.fields.repository.IFieldJpaRepository;
import com.devPortes.reservations.entities.ReservationEntity;
import com.devPortes.reservations.mapper.ReservationOutMapper;
import com.devPortes.reservations.model.Reservation;
import com.devPortes.users.entities.ClientEntity;
import com.devPortes.users.exceptions.UserNotFoundException;
import com.devPortes.users.model.Client;
import com.devPortes.users.repository.IClientJpaRepository;
import com.devPortes.users.repository.UserJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationJpaRepositoryAdapter {
    private final IReservationJpaRepository jpa;
    private final IClientJpaRepository clientRepository;
    private final IFieldJpaRepository fieldRepository;

    public List<Reservation> findByReservationDate(LocalDate date) {
        List<ReservationEntity> reservationEntities = jpa.findByReservationDate(date);
        return ReservationOutMapper.toModelList(reservationEntities);
    }

    @Transactional
    public Reservation save(Reservation model) {
        ClientEntity client = clientRepository.findById(model.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(model.getUser().getId())));

        FieldEntity field = fieldRepository.findById(model.getField().getId())
                .orElseThrow(() -> new FieldRepositoryNotFoundException(model.getField().getId()));

        ReservationEntity entity = ReservationOutMapper.toEntity(model, client, field);

        return ReservationOutMapper.toModel(jpa.save(entity));
    }

}
