package com.marcin.microservices.order.service;

import com.marcin.microservices.order.dto.OrderRequest;
import com.marcin.microservices.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderRequest.price())
                .skuCode(orderRequest.skuCode())
                .quantity(orderRequest.quantity())
                .build();
    }
}
