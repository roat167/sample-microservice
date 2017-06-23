package io.kapp.samplemicroservice.customer.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kapp.samplemicroservice.customer.data.domain.Customer;
import io.kapp.samplemicroservice.customer.exception.BaseException;
import io.kapp.samplemicroservice.customer.exception.CustomerException;
import io.kapp.samplemicroservice.customer.exception.Response;
import io.kapp.samplemicroservice.customer.service.CustomerService;

@RestController
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;	
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers() {
    	logger.info("CustomerController.clazz getCustomers()");
		return new ResponseEntity<List<Customer>>(customerService.getAll(), HttpStatus.OK);    	
	}
	
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) throws CustomerException {
    	logger.info("CustomerController.clazz getCustomer() id" + id);
    	
    	Customer customer = customerService.getById(id);
    	System.out.println("Customer " + customer);
    	if (customer == null || customer.getId() <= 0){
            throw new CustomerException("Customer can not be found!");
    	}
		return new ResponseEntity<Customer>(customerService.getById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> delete(@PathVariable("id") long id) throws CustomerException {
    	logger.info("CustomerController.clazz delete() id" + id);
    	
    	Customer customer = customerService.getById(id);
    	if (customer == null || customer.getId() <= 0){
            throw new CustomerException("Customer to delete can not be found");
    	}
		customerService.remove(customer);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Customer has been deleted successfully"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/customer", method = RequestMethod.POST)		
   	public ResponseEntity<Customer> saveCustomer(@Validated @RequestBody Customer customer) throws BaseException {
    	logger.info("CustomerController.clazz saveCustomer() customer" + customer);    	
		return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/customer", method = RequestMethod.PATCH)
   	public ResponseEntity<Customer>  updateCustomer(@Validated @RequestBody Customer customer) throws BaseException {
    	logger.info("CustomerController.clazz updateCustomer() customer " + customer);
    	Customer cust = customerService.getById(customer.getId());
    	if (cust == null || cust.getId() <= 0){
            throw new CustomerException("Failed, customer doesn't exist");
    	}
		return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);
   	}
}
