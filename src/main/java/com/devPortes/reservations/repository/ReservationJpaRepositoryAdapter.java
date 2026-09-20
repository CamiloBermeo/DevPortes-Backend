package com.devPortes.reservations.repository;

import com.devPortes.fields.entities.FieldEntity;
import com.devPortes.fields.exceptions.FieldRepositoryNotFoundException;
import com.devPortes.fields.model.Field;
import com.devPortes.fields.repository.FieldJpaRepositoryAdapter;
import com.devPortes.fields.repository.IFieldJpaRepository;
import com.devPortes.reservations.entities.ReservationEntity;
import com.devPortes.reservations.mapper.ReservationOutMapper;
import com.devPortes.reservations.model.EstadoReservationEnum;
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

    @Transactional(readOnly = true)
    public List<Reservation> findByReservationDate(LocalDate date) {
        List<ReservationEntity> reservationEntities = jpa.findByReservationDateAndStateNot(date, EstadoReservationEnum.CANCELADA);
        return ReservationOutMapper.toModelList(reservationEntities);
    }

    @Transactional(readOnly = true)
    public List<Reservation> findByDateRange(LocalDate startDate, LocalDate endDate) {
        List<ReservationEntity> reservationEntities = jpa.findByReservationDateBetweenAndStateNot(startDate, endDate, EstadoReservationEnum.CANCELADA);
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

    @Transactional(readOnly = true)
    public List<Reservation> findPendingByUserId(Long userId) {
        List<ReservationEntity> entities = jpa.findByClientEntity_IdAndState(userId, EstadoReservationEnum.PENDIENTE);
        return ReservationOutMapper.toModelList(entities);
    }

    @Transactional(readOnly = true)
    public List<Reservation> findAllByUserId(Long userId) {
        List<ReservationEntity> entities = jpa.findByClientEntity_IdOrderByReservationDateDesc(userId);
        return ReservationOutMapper.toModelList(entities);
    }

    @Transactional
    public Reservation cancelByIdAndUserId(Long reservationId, Long userId) {
        ReservationEntity entity = jpa.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada: " + reservationId));

        if (!entity.getClientEntity().getId().equals(userId)) {
            throw new RuntimeException("No tienes permiso para cancelar esta reserva");
        }

        entity.setState(EstadoReservationEnum.CANCELADA);
        return ReservationOutMapper.toModel(jpa.save(entity));
    }

}
