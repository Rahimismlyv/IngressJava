package org.example.ms28spring.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.ms28spring.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="orders")
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDate creationDate;
    private String transactionNumber;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
