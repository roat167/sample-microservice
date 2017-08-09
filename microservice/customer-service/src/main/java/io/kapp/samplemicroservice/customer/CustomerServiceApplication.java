package io.kapp.samplemicroservice.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.kapp.samplemicroservice.customer.data.domain.Customer;
import io.kapp.samplemicroservice.customer.service.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(CustomerService customerService) {
		return args -> {	
			
			Customer cust = customerService.getById(1L);	
			System.out.println(cust);
			
			if (cust == null) {
				cust = new Customer(1L, "kloem", "password", "khemroat", "loem", "", "");
				customerService.save(cust);
				System.out.println("new " + cust);
			}
			
			System.out.println(customerService.getByUsername("kloem"));			
		};
	}
}
