package com.vijay.ecommerce.kafka;

import com.vijay.ecommerce.customer.CustomerResponse;
import com.vijay.ecommerce.order.PaymentMethod;
import com.vijay.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
