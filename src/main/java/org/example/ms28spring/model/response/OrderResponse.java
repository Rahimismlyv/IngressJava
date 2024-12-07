package org.example.ms28spring.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ms28spring.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private LocalDate creationDate;
    private String transactionNumber;
    private BigDecimal amount;
}
