package com.vijay.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
         String id,

         @NotNull(message = "Customer firstname required")
         String firstName,

         @NotNull(message = "Customer lastName required")
         String lastName,

         @NotNull(message = "Customer email required")
         @Email(message = "Customer email is not a valid email address")
         String email,
         Address address
) {
}
