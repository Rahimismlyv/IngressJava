package org.example.ms28spring.controller;


import lombok.RequiredArgsConstructor;
import org.example.ms28spring.dao.repository.ReservationsRepository;
import org.example.ms28spring.model.request.CreateReservationsRequest;
import org.example.ms28spring.model.response.ReservationsResponse;
import org.example.ms28spring.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("v1/reservations")
@RequiredArgsConstructor
public class ReservationsController {
    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReservation(@RequestBody CreateReservationsRequest request){
        reservationService.saveReservations(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservations(id);
    }

    @GetMapping("/{id}")
    public ReservationsResponse getReservation(@PathVariable Long id){
        return reservationService.getReservations(id);
    }

    @GetMapping("/{reservationDate}")
    public ReservationsResponse getReservationByDate(@PathVariable LocalDate reservationDate){
        return reservationService.getReservationsInDate(reservationDate);
    }


}
