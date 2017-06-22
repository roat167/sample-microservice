package io.kapp.samplemicroservice.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kapp.samplemicroservice.customer.data.domain.Customer;
import io.kapp.samplemicroservice.customer.data.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getById(Long id) {
		return customerRepository.findFirstById(id);
	}	

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void remove(Customer customer) {		
		customerRepository.delete(customer);
	}

	@Override
	public Customer getByUsername(String username) {		
		return customerRepository.findUsername(username);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
	
	
}
