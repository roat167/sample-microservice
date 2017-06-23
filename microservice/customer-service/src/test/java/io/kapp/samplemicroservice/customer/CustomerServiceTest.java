package io.kapp.samplemicroservice.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.theInstance;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;	
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.kapp.samplemicroservice.customer.data.domain.Customer;
import io.kapp.samplemicroservice.customer.data.repository.CustomerRepository;
import io.kapp.samplemicroservice.customer.exception.DuplicateUsernameException;
import io.kapp.samplemicroservice.customer.service.CustomerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
    CustomerServiceImpl customerService;

	/**
	 * using BeforeClass will execute the test once before other Tests
	 */
    @BeforeClass
    public static void setUp() {   
    	//init mock
    	MockitoAnnotations.initMocks(theInstance(CustomerServiceTest.class));	    	
    }
	
    @Test
    public void findAll() {
    	List<Customer> customers = new ArrayList<>();    	
    	customers.add(new Customer("kavenger", "password", "Kora", "Avenger"));
    	customers.add(new Customer("otwist", "password", "Oliver", "Twist"));
    	customers.add(new Customer("sholmes", "password", "Sherklock", "Holmes"));
    	when(customerService.getAll()).thenReturn(customers);
    	
    	assertEquals(3, customerService.getAll().size());
    }

    @Test
    public void findsByUsername() throws DuplicateUsernameException {
    	String username = "abc";
    	Customer customer = new Customer(username, "password", "Kora", "Avenger");
    	customerService.save(customer);
    	
    	verify(customerRepository, times(1)).save(customer);
		when(customerService.getByUsername(username)).thenReturn(customer);
		
		Customer result = customerService.getByUsername(username);		
        assertThat(result).extracting("firstName").contains("Kora");        
    }   
    
    @Test
    public void findById() throws DuplicateUsernameException {
    	Customer customer = new Customer(1L, "kloem", "password", "khemroat", "loem", "", "");
    	customerService.save(customer);
    	verify(customerRepository, times(1)).save(customer);
		when(customerService.getById(1L)).thenReturn(customer);
		
		Customer result = customerService.getById(1L);
		assertEquals(1, result.getId().longValue());
		assertEquals("loem", result.getLastName());		
    }
    
   @Test 
   public void deleteCustomer() {
		Customer customer = new Customer(1L, "kloem", "password", "khemroat", "loem", "", "");		
		customerService.remove(customer);
        verify(customerRepository, times(1)).delete(customer);
   }
}
