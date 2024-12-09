package org.example.ms28spring.dao.repository;

import org.example.ms28spring.dao.entity.ReservationsEntity;
import org.example.ms28spring.model.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationsRepository extends CrudRepository<ReservationsEntity,Long> {
    Optional<ReservationsEntity> findByIdAndStatusNot(Long id, ReservationStatus status);

    Optional<ReservationsEntity> findByStatusAndReservationDate(ReservationStatus status, LocalDate reservationDate);
}
