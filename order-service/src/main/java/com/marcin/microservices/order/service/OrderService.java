package com.marcin.microservices.order.service;

import com.marcin.microservices.order.dto.OrderRequest;
import com.marcin.microservices.order.model.Order;
import com.marcin.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public void placeOrder(OrderRequest orderRequest) {

        Order order = orderMapper.toOrder(orderRequest);

        orderRepository.save(order);

    }
}
