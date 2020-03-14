package com.manishsonava.tSystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Elements {

	@JsonProperty("page_link")
	private String pageLink;

	@JsonProperty("page_title")
	private String pageTitle;

	@JsonProperty("image_count")
	private Integer imageCount;

	public String getPageLink() {
		return pageLink;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public Integer getImageCount() {
		return imageCount;
	}

	public void setImageCount(Integer imageCount) {
		this.imageCount = imageCount;
	}

}
