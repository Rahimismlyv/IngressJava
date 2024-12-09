package org.example.ms28spring.service;


import lombok.RequiredArgsConstructor;
import org.example.ms28spring.dao.entity.ReservationsEntity;
import org.example.ms28spring.dao.repository.ReservationsRepository;
import org.example.ms28spring.model.enums.ReservationStatus;
import org.example.ms28spring.model.request.CreateReservationsRequest;
import org.example.ms28spring.model.response.ReservationsResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReservationsServiceHandler implements ReservationService {
    private final ReservationsRepository reservationsRepository;

    @Override
    public void saveReservations(CreateReservationsRequest reservations) {
        reservationsRepository.save(ReservationsEntity.builder()
                        .tableName(reservations.getTableName())
                        .customer(reservations.getCustomer())
                        .reservationDate(reservations.getReservationDate())
                        .membersCount(reservations.getMembersCount())
                .build());
    }

    @Override
    public void deleteReservations(Long id) {
        var reservations = findReservationById(id);
        reservations.setStatus(ReservationStatus.DELETED);
        reservationsRepository.save(reservations);
    }

    @Override
    public ReservationsResponse getReservations(Long id) {
        var reservations = findReservationById(id);
        return new ReservationsResponse(reservations.getTableName(),
                reservations.getCustomer(), reservations.getReservationDate(),
                reservations.getMembersCount());
    }

    @Override
    public ReservationsResponse getReservationsInDate(LocalDate date) {
        var reservations = reservationsRepository.
                findByStatusAndReservationDate(ReservationStatus.ACTIVE, date)
                .orElseThrow(RuntimeException::new);
        return new ReservationsResponse(reservations.getTableName(),
                reservations.getCustomer(), reservations.getReservationDate(),
                reservations.getMembersCount());
    }

    private ReservationsEntity findReservationById(Long id) {
        return reservationsRepository.findByIdAndStatusNot(id,ReservationStatus.DELETED)
                .orElseThrow(()-> new RuntimeException("Reservation not found"));
        }
    }


