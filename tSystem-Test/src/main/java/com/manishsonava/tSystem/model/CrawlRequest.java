package com.manishsonava.tSystem.model;

import javax.validation.constraints.NotNull;

public class CrawlRequest {

	@NotNull(message = "baseURL is mandatory")
	private String baseURL;
	@NotNull(message = "depth is mandatory")
	private Integer depth;

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

}
