package org.example.ms28spring.dao.repository;

import org.example.ms28spring.dao.entity.OrderEntity;
import org.example.ms28spring.model.enums.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
    Optional<OrderEntity> findByIdAndStatusNot(Long id, OrderStatus status);

}
