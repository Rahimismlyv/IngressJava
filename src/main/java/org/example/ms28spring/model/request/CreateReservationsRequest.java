package org.example.ms28spring.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationsRequest {
    private String tableName;
    private String customer;
    private LocalDate reservationDate;
    private Integer membersCount;

}
