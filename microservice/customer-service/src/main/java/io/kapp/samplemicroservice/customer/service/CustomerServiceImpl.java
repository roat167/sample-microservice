package io.kapp.samplemicroservice.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.kapp.samplemicroservice.customer.data.domain.Customer;
import io.kapp.samplemicroservice.customer.data.repository.CustomerRepository;
import io.kapp.samplemicroservice.customer.exception.DuplicateUsernameException;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getById(Long id) {
		return customerRepository.findOne(id);
	}	

	@Override
	@Transactional
	public Customer save(Customer customer) throws DuplicateUsernameException {
		Customer temp = customerRepository.findFirstByUsername(customer.getUsername()); 
		if (temp != null && ! (temp.getId().equals(customer.getId()))) {
			throw new DuplicateUsernameException("Username is already taken!");
		}
		return customerRepository.save(customer);
	}

	@Override	
	public void remove(Customer customer) {		
		customerRepository.delete(customer);
	}

	@Override
	public Customer getByUsername(String username) {		
		return customerRepository.findByUsername(username);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}	
	
}
