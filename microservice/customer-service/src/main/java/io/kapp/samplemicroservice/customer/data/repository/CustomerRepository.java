package io.kapp.samplemicroservice.customer.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import io.kapp.samplemicroservice.customer.data.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
	Customer findFirstById(Long id);

	Customer findFirstByUsername(String username);

	// using native json query string
	@Query("{username:'?0'")
	Customer findByUsername(String username);

	// using regex
	@Query("{username:{ $regex: ?0}}")
	List<Customer> findCustomerByUsername(String username);
}
