package com.vijay.ecommerce.mapper;

import com.vijay.ecommerce.order.Order;
import com.vijay.ecommerce.orderLine.OrderLine;
import com.vijay.ecommerce.orderLine.OrderLineRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .productId(request.productId())
                .quantity(request.quantity())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .build();
    }
}
