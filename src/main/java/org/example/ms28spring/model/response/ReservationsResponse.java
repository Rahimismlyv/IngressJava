package org.example.ms28spring.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationsResponse {
    private String tableName;
    private String customer;
    private LocalDate reservationDate;
    private Integer membersCount;

}
