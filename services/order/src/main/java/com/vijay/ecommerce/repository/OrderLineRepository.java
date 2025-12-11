package com.vijay.ecommerce.repository;

import com.vijay.ecommerce.order.Order;
import com.vijay.ecommerce.order.OrderResponse;
import com.vijay.ecommerce.orderLine.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> order(Order order);

    List<OrderLine> findAllByOrderId(Integer orderId);
}
