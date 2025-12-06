package com.vijay.ecommerce.repository;

import com.vijay.ecommerce.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
