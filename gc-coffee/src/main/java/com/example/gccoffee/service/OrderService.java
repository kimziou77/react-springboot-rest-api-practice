package com.example.gccoffee.service;

import com.example.gccoffee.model.Email;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
public interface OrderService {
    Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems);
}
