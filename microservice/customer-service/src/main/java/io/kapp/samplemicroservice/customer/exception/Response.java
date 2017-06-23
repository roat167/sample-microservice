package io.kapp.samplemicroservice.customer.exception;

public class Response {	
	private int code;
	private String url;
	private String message;
	
	public Response (int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Response (int code, String message, String url) {
		this.code = code;
		this.message = message;
		this.url = url;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}	
}
