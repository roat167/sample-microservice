package io.kapp.samplemicroservice.customer.exception;

public class DuplicateUsernameException extends BaseException {
	private static final long serialVersionUID = 1L;

	public DuplicateUsernameException(String errorMsg) {
		super(errorMsg);
	}

}
