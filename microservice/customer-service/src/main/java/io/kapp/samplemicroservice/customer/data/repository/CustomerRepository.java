package io.kapp.samplemicroservice.customer.data.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import io.kapp.samplemicroservice.customer.data.domain.Customer;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
	Customer findFirstById(Long id);
	@Query("select distinct c from Customer c where c.username=:username")
	Customer findUsername(@Param(value="username") String username);	
}
