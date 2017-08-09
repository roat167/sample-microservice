package io.kapp.samplemicroservice.order.exception;

public class OrderException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public OrderException(String message) {
		super(message);	
	}
}
