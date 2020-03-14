package com.manishsonava.tSystem.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CrawlResponse {

	@Id
	private String token;
	private CrawlStatus status;
	@JsonIgnore
	private CrawlRequest crawlRequest;
	private List<Errors> errors;

	public CrawlStatus getStatus() {
		return status;
	}

	public void setStatus(CrawlStatus status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public CrawlRequest getCrawlRequest() {
		return crawlRequest;
	}

	public void setCrawlRequest(CrawlRequest crawlRequest) {
		this.crawlRequest = crawlRequest;
	}

	public List<Errors> getErrors() {
		return errors;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

}
