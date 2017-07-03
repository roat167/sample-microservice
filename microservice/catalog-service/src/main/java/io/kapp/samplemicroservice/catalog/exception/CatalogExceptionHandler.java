package io.kapp.samplemicroservice.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CatalogExceptionHandler {
	
	@ExceptionHandler(CatalogException.class)
	public ResponseEntity<Response> exceptionCustomerHandler(Exception ex) {
		Response error = new Response(HttpStatus.NOT_FOUND.value(), ex.getMessage());		
		return new ResponseEntity<Response>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exceptionHandler(BaseException ex) {
		Response error = new Response(HttpStatus.BAD_REQUEST.value(), "Malformed syntax, server can not uderstand the request " + ex.getMessage());
		return new ResponseEntity<Response>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateNameException.class)
	public ResponseEntity<Response> exceptionUserNotFoundHandler(DuplicateNameException ex) {
		Response error = new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return new ResponseEntity<Response>(error, HttpStatus.NOT_FOUND);
	}
}
