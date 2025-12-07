package com.vijay.ecommerce.repository;

import com.vijay.ecommerce.orderLine.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
