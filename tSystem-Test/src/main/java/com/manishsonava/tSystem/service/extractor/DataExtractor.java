package com.manishsonava.tSystem.service.extractor;

import com.manishsonava.tSystem.model.SiteData;

public interface DataExtractor {
	
	SiteData getLinkDetails(String url);

}
