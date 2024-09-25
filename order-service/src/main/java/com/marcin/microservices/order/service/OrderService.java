package com.marcin.microservices.order.service;

import com.marcin.microservices.order.client.InventoryClient;
import com.marcin.microservices.order.dto.OrderRequest;
import com.marcin.microservices.order.model.Order;
import com.marcin.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    private final OrderMapper orderMapper;

    public void placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (isProductInStock) {
            Order order = orderMapper.toOrder(orderRequest);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is not in stock");
        }
    }
}
