package com.manishsonava.tSystem.exception;

/**
 * CrawlRequestNotFoundException is thrown when request token is not found.
 * @author Manish Sonava
 *
 */
@SuppressWarnings("serial")
public class CrawlRequestNotFoundException extends RuntimeException {

	private String token;

	public CrawlRequestNotFoundException(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
