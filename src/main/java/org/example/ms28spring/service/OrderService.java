package org.example.ms28spring.service;

import org.example.ms28spring.model.request.CreateOrderRequest;
import org.example.ms28spring.model.request.UpdateAmountRequest;
import org.example.ms28spring.model.response.OrderResponse;

public interface OrderService {
    void saveOrder(CreateOrderRequest order);

    void updateOrderAmount(Long id, UpdateAmountRequest request);

    void deleteOrder(Long id);

    OrderResponse getOrder(Long id);
}
