package com.marcin.microservices.order.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderPlacedEvent {

    private String orderNumber;
    private String email;
}
