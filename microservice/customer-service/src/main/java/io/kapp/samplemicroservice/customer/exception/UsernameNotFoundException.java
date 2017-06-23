package io.kapp.samplemicroservice.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends BaseException {	
	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String username) {
		super("Username '"+ username + "' can not be found.");
	}
}
