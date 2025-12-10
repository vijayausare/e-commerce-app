package com.vijay.ecommerce.mapper;

import com.vijay.ecommerce.order.Order;
import com.vijay.ecommerce.order.OrderRequest;
import com.vijay.ecommerce.order.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
         return  Order.builder()
                 .id(request.id())
                 .customerId(request.customerId())
                 .reference(request.reference())
                 .totalAmount(request.amount())
                 .paymentMethod(request.paymentMethod())
                 .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
