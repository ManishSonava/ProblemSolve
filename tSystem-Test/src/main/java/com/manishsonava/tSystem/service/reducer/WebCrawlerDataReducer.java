package com.manishsonava.tSystem.service.reducer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.manishsonava.tSystem.model.Elements;
import com.manishsonava.tSystem.model.LinkType;
import com.manishsonava.tSystem.model.Page;
import com.manishsonava.tSystem.model.SiteData;
import com.manishsonava.tSystem.model.WebCrawledElements;

/**
 * WebCrawlerDataReducer class to provide the desired output for the crawled pages.
 * @author Manish Sonava
 *
 */
@Component
public class WebCrawlerDataReducer {
	
	/**
	 * Method to return the crawled results in the below format.
	 * {
    "total_links": 2,
    "total_images": 3,
    "details": [
        {
            "page_title": "12",
            "page_link": "qwww",
            "image_count": 2
        },
        {
            "page_title": "12",
            "page_link": "qw",
            "image_count": 3
        }
    ]
}
	 * 
	 * @param crawledPages
	 * @param token
	 * @return
	 */
	public WebCrawledElements mapCrawledElements(final List<Page> crawledPages, final String token) {
		WebCrawledElements crawledElements = new WebCrawledElements();
		int totalLinks = 0;
		int totalImages = 0;
		List<Elements> elements = new ArrayList<Elements>();
		for(Page page: crawledPages) {
			int pageImages = 0;
			int pageLinks = 0;
			Elements element = new Elements();
			element.setPageTitle(page.getTitle());
			element.setPageLink(page.getLink());
			for(SiteData siteData: page.getSiteDatas()) { 
				if(LinkType.IMAGE.equals(siteData.getLinkType())) { // function factory can be added which will mutate the object for every iteration.
					pageImages += 1;
				}
				if(LinkType.LINK.equals(siteData.getLinkType())) {
					pageLinks += 1;
				}
			}
			totalImages =+ pageImages;
			totalLinks =+ pageLinks;
			element.setImageCount(pageImages);
			elements.add(element);
		}
		crawledElements.setElements(elements);
		crawledElements.setTotalImages(totalImages);
		crawledElements.setTotalLinks(totalLinks);
		crawledElements.setToken(token);
		return crawledElements;
	}

}
