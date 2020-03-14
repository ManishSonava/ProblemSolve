package com.manishsonava.tSystem.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebCrawledElements {

	@Id
	private String token;

	@JsonProperty("total_links")
	private Integer totalLinks;

	@JsonProperty("total_images")
	private Integer totalImages;

	@JsonProperty("details")
	private List<Elements> elements;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getTotalLinks() {
		return totalLinks;
	}

	public void setTotalLinks(Integer totalLinks) {
		this.totalLinks = totalLinks;
	}

	public Integer getTotalImages() {
		return totalImages;
	}

	public void setTotalImages(Integer totalImages) {
		this.totalImages = totalImages;
	}

	public List<Elements> getElements() {
		return elements;
	}

	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}

}
