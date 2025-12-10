package com.vijay.ecommerce.kafka;

import com.vijay.ecommerce.client.customer.CustomerResponse;
import com.vijay.ecommerce.client.product.PurchaseResponse;
import com.vijay.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderRefernce,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
