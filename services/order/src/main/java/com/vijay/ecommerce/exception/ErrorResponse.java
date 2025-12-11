package com.vijay.ecommerce.exception;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
