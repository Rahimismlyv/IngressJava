package org.example.ms28spring.service;

import lombok.RequiredArgsConstructor;
import org.example.ms28spring.dao.entity.OrderEntity;
import org.example.ms28spring.dao.repository.OrderRepository;
import org.example.ms28spring.model.enums.OrderStatus;
import org.example.ms28spring.model.request.CreateOrderRequest;
import org.example.ms28spring.model.request.UpdateAmountRequest;
import org.example.ms28spring.model.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderServiceHandler implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void saveOrder(CreateOrderRequest order) {
        orderRepository.save(
                OrderEntity.builder().
                        amount(order.getAmount()).
                        creationDate(LocalDate.now()).
                        transactionNumber(order.getTransactionNumber()).build()
        );
    }

    @Override
    public void updateOrderAmount(Long id,
                                  UpdateAmountRequest request) {
        var order = fetchOrderIfExist(id);

        order.setAmount(request.getAmount());

        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        var order = fetchOrderIfExist(id);
        order.setStatus(OrderStatus.DELETED);
        orderRepository.save(order);
    }

    @Override
    public OrderResponse getOrder(Long id) {
        var order = fetchOrderIfExist(id);
        return new OrderResponse(order.getCreationDate(),order.getTransactionNumber(),order.getAmount());
    }

    private OrderEntity fetchOrderIfExist(Long id) {
        return  orderRepository.findByIdAndStatusNot(id,OrderStatus.DELETED)
                .orElseThrow(()-> new RuntimeException("Order not found"));
    }


}
