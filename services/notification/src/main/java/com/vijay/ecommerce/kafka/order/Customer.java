package com.vijay.ecommerce.kafka.order;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record Customer(
        String id,

        String firstName,

        String lastName,

        String email
) {
}
