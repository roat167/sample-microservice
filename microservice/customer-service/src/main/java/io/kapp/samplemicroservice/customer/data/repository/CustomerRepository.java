package io.kapp.samplemicroservice.customer.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.kapp.samplemicroservice.customer.data.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
	Customer findFirstById(Long id);
	Customer findFirstByUsername(String username);
}
	