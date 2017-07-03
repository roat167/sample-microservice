package io.kapp.samplemicroservice.catalog.exception;

public class DuplicateNameException extends BaseException {
	private static final long serialVersionUID = 1L;

	private String error;

	public DuplicateNameException(String error) {
		super(error);
		this.error = error;
	}

	public String getError() {
		return this.error;
	}

}
