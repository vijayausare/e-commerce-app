package com.vijay.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
         Integer id,

         @NotNull(message = "Product name id requied")
         String name,

         @NotNull(message = "Description name id requied")
         String description,

         @Positive(message = "Available Quantity should be positive")
         double availableQuantity,

         @Positive(message = "Price should be positive")
         BigDecimal price,

         @NotNull(message = "Category is required")
         Integer categoryId
) {
}
