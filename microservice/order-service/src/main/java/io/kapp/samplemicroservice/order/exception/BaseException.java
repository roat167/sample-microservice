package io.kapp.samplemicroservice.order.exception;

public class BaseException extends Exception {
	private static final long serialVersionUID = 1L;

	public BaseException(String message) {
		super(message);
	}
}
