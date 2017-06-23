package io.kapp.samplemicroservice.customer.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import io.kapp.samplemicroservice.customer.data.domain.Customer;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramclass) {
		return Customer.class.equals(paramclass);
	}

	@Override
	public void validate(Object obj, Errors err) {		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "id", "id.required");		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "firstName", "firstname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "lastName", "lastname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "email", "email.required");		
	}
}
