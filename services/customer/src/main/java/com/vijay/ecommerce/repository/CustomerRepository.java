package com.vijay.ecommerce.repository;

import com.vijay.ecommerce.client.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
