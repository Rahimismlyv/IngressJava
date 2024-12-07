package org.example.ms28spring.controller;

import lombok.*;
import org.example.ms28spring.model.request.CreateOrderRequest;
import org.example.ms28spring.model.request.UpdateAmountRequest;
import org.example.ms28spring.model.response.OrderResponse;
import org.example.ms28spring.service.OrderService;
import org.example.ms28spring.service.OrderServiceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(@RequestBody CreateOrderRequest order ){
            orderService.saveOrder(order);
    }
    @PatchMapping("/{id}/amount")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrderAmount(@PathVariable Long id,
                                  @RequestBody UpdateAmountRequest request){
        orderService.updateOrderAmount(id, request  );
    };

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }

}
