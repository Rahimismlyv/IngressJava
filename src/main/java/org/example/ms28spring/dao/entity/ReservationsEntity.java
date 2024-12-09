package org.example.ms28spring.dao.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.ms28spring.model.enums.ReservationStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of ="id")
@Table(name="reservations")
@Builder
public class ReservationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;
    private String customer;
    private LocalDate reservationDate;
    private Integer membersCount;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
