package com.example.gccoffee.controller.api;

import com.example.gccoffee.controller.CreateOrderRequest;
import com.example.gccoffee.model.Email;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/api/v1/orders")
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest){
        return orderService.createOrder(
                new Email(orderRequest.email()),
                orderRequest.address(),
                orderRequest.postcode(),
                orderRequest.orderItems()
        );
    }

}
