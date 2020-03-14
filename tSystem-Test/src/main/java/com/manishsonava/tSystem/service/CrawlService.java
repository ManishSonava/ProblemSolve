package com.manishsonava.tSystem.service;

import com.manishsonava.tSystem.model.CrawlRequest;
import com.manishsonava.tSystem.model.CrawlResponse;
import com.manishsonava.tSystem.model.WebCrawledElements;

/**
 * CrawlService interface exposes the behaviour for working on the crawls.
 * @author Manish Sonava
 *
 */
public interface CrawlService {
	
	/**
	 * Method to define the behaviour for accepting crawl request.
	 * @param crawlRequest
	 * @return
	 */
	CrawlResponse crawlWeb(final CrawlRequest crawlRequest);
	
	/**
	 * Method to define the behaviour for getting crawl request status.
	 * @param crawlRequestToken
	 * @return
	 */
	CrawlResponse getCrawlWebStatus(final String crawlRequestToken);
	
	/**
	 * Method to define the behaviour for getting the crawl request result.
	 * @param crawlRequestToken
	 * @return
	 */
	WebCrawledElements getCrawlWebResults(final String crawlRequestToken);

}
