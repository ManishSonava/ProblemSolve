package com.manishsonava.tSystem.model;

import java.util.List;

public class Page {

	private String title;
	private String link;
	private List<SiteData> siteDatas;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<SiteData> getSiteDatas() {
		return siteDatas;
	}

	public void setSiteDatas(List<SiteData> siteDatas) {
		this.siteDatas = siteDatas;
	}

}
