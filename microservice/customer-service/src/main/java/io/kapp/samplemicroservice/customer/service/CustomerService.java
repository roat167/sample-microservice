package io.kapp.samplemicroservice.customer.service;

import java.util.List;

import io.kapp.samplemicroservice.customer.data.domain.Customer;
import io.kapp.samplemicroservice.customer.exception.DuplicateUsernameException;

public interface CustomerService {
	Customer getById(Long id);	
	Customer save(Customer customer) throws DuplicateUsernameException;
	void remove(Customer customer);
	Customer getByUsername(String username);
	List<Customer> getAll();
}
