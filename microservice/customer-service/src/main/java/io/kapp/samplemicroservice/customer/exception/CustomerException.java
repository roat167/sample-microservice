package io.kapp.samplemicroservice.customer.exception;

public class CustomerException extends BaseException {
	private static final long serialVersionUID = 1L;
	private String errorMsg;	

	public CustomerException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}	

	public String getErrorMsg() {
		return this.errorMsg;
	}
}
