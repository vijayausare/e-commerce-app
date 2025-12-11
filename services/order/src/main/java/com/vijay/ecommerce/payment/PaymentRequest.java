package com.vijay.ecommerce.payment;

import com.vijay.ecommerce.client.customer.CustomerResponse;
import com.vijay.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
