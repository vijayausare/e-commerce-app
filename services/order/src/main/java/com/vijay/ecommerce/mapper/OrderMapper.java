package com.vijay.ecommerce.mapper;

import com.vijay.ecommerce.order.Order;
import com.vijay.ecommerce.order.OrderRequest;
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
}
