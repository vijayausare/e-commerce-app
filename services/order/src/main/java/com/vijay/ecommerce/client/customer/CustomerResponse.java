package com.vijay.ecommerce.client.customer;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
