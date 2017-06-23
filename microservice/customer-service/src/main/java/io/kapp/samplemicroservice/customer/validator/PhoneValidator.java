package io.kapp.samplemicroservice.customer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone arg0) {
	}

	@Override
	public boolean isValid(String contactNo, ConstraintValidatorContext cvctx) {
		if (contactNo == null) {
			return false;
		}
		// validate format is number from [0-9]
		if (contactNo.length() == 0 || contactNo.matches("\\d{10}")) {
			return true;		
		} // validating phone number with -, . or spaces
		else if (contactNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
			return true;
		}// validating phone number with extension length from 3 to 5
		else if (contactNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
			return true;
		}// validating phone number where area code is in braces ()
		else if (contactNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
			return true;
		}
		
		return false;
		
	}

}
