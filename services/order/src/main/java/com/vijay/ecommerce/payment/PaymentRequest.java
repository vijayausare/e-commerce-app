package com.vijay.ecommerce.payment;

import com.vijay.ecommerce.customer.CustomerResponse;
import com.vijay.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
