package io.kapp.samplemicroservice.customer.data.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	@Id
	private Long id;
	@Indexed
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;

	public Customer() {}
	
	public Customer(String username, String password, String firstName, String lastName) {	
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}	
	
	public Customer(long id, String username, String password, String firstName, String lastName, String email, String contactNo) {		
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Customer [id=").append(this.id)
				.append(", firstname=").append(this.firstName)
				.append(", lastname=").append(this.lastName)
				.append(", email=").append(this.email)
				.append(", contactNo=").append(this.contactNo).append("]").toString();
	}

}
