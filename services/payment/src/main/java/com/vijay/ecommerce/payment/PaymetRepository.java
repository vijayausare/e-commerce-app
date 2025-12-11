package com.vijay.ecommerce.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymetRepository extends JpaRepository<Payment, Integer> {
}
