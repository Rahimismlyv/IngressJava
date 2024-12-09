package org.example.ms28spring.service;

import org.example.ms28spring.model.request.CreateReservationsRequest;
import org.example.ms28spring.model.response.ReservationsResponse;

import java.time.LocalDate;

public interface ReservationService {
    void saveReservations(CreateReservationsRequest reservations);

    void deleteReservations(Long id);

    ReservationsResponse getReservations(Long id);

    ReservationsResponse getReservationsInDate(LocalDate date);
}
