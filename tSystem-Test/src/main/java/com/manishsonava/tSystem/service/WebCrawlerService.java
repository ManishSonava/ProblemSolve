package com.manishsonava.tSystem.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.manishsonava.tSystem.model.Page;
import com.manishsonava.tSystem.model.SiteData;
import com.manishsonava.tSystem.service.extractor.DataExtractor;

/**
 * WebCrawlerService class to handle the page reading and parsing logic.
 * @author Manish Sonava
 *
 */
@Service
public class WebCrawlerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawlerService.class);

	private List<DataExtractor> extrators;

	/**
	 * Method to read and parse the page asynchronously.
	 * @param url
	 * @return
	 */
	@Async
	public Page getCrawledSiteData(final String url) {

		List<SiteData> siteDatas = new ArrayList<>();
		Page page = new Page();
		page.setLink(url);
		try {
			URL pageUrl = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(pageUrl.openStream()));
			String strTemp = null;
			while (null != (strTemp = br.readLine())) {
				final String htmlRow = strTemp;
				extrators.stream().forEach(extractor -> {
					siteDatas.add(extractor.getLinkDetails(htmlRow));
				});
			}
			page.setSiteDatas(siteDatas);
		} catch (Exception exception) {
			LOGGER.error("error occured while crawling -> {}", exception);
			// throw exception
		}

		return page;

	}

}
