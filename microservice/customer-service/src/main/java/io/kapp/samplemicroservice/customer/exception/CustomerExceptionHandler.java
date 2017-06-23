package io.kapp.samplemicroservice.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<Response> exceptionCustomerHandler(Exception ex) {
		Response error = new Response(HttpStatus.NOT_FOUND.value(), ex.getMessage());		
		return new ResponseEntity<Response>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exceptionHandler(BaseException ex) {
		Response error = new Response(HttpStatus.BAD_REQUEST.value(), "Malformed syntax, server can not uderstand the request " + ex.getMessage());
		return new ResponseEntity<Response>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<Response> exceptionUserNotFoundHandler(RuntimeException ex) {
		Response error = new Response(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<Response>(error, HttpStatus.NOT_FOUND);
	}
}
