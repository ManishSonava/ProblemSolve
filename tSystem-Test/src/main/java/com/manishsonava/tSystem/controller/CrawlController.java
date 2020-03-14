package com.manishsonava.tSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manishsonava.tSystem.model.CrawlRequest;
import com.manishsonava.tSystem.model.CrawlResponse;
import com.manishsonava.tSystem.model.WebCrawledElements;
import com.manishsonava.tSystem.service.CrawlService;

/**
 * CrawlController class to expose the rest endpoints to either submit the request for crawling, read the status or get the results for ready crwals.
 * @author Manish Sonava
 *
 */
@RestController
@RequestMapping("/")
public class CrawlController {
	
	@Autowired
	private CrawlService crawlService;

	/**
	 * Method to submit the crawl request.
	 * @param request
	 * @return
	 */
	@PostMapping(value = "crawl", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public CrawlResponse crawlWeb(@RequestBody @Valid final CrawlRequest request) {
		return crawlService.crawlWeb(request);
	}
	
	/**
	 * Method to check the cralw status.
	 * @param crawlRequestToken
	 * @return
	 */
	@GetMapping(value = "crawls/{token}/status", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CrawlResponse getCrawlStatus(@PathVariable(name = "token", required = true) final String crawlRequestToken) {
		return crawlService.getCrawlWebStatus(crawlRequestToken);
	}
	
	/**
	 * Method to read the crawl request's results.
	 * @param crawlRequestToken
	 * @return
	 */
	@GetMapping(value = "crawls/{token}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public WebCrawledElements getCrawlResults(@PathVariable(name = "token", required = true) final String crawlRequestToken) {
		return crawlService.getCrawlWebResults(crawlRequestToken);
	}

}
