package com.manishsonava.tSystem.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manishsonava.tSystem.exception.CrawlRequestNotFoundException;
import com.manishsonava.tSystem.model.CrawlRequest;
import com.manishsonava.tSystem.model.CrawlResponse;
import com.manishsonava.tSystem.model.CrawlStatus;
import com.manishsonava.tSystem.model.WebCrawledElements;
import com.manishsonava.tSystem.repository.CrawlElementsMongoRepository;
import com.manishsonava.tSystem.repository.CrawlMongoRepository;

/**
 * CrawlServiceImpl class provides an implementation to crawl service behaviours.
 * @author Manish Sonava
 *
 */
@Service
public class CrawlServiceImpl implements CrawlService {

	@Autowired
	private CrawlMongoRepository crawlMongoRepository;

	@Autowired
	private CrawlElementsMongoRepository crawlElementsMongoRepository;

	@Override
	public CrawlResponse crawlWeb(CrawlRequest crawlRequest) {
		CrawlResponse crawlResponse = new CrawlResponse();
		crawlResponse.setToken(UUID.randomUUID().toString());
		crawlResponse.setStatus(CrawlStatus.SUBMITTED);
		crawlResponse.setCrawlRequest(crawlRequest);
		crawlMongoRepository.insert(crawlResponse);
		return crawlResponse;
	}

	@Override
	public CrawlResponse getCrawlWebStatus(String crawlRequestToken) {
		Optional<CrawlResponse> crawlResponse = crawlMongoRepository.findById(crawlRequestToken);
		if (crawlResponse.isPresent()) {
			return crawlResponse.get();
		} else {
			throw new CrawlRequestNotFoundException(crawlRequestToken);
		}
	}

	@Override
	public WebCrawledElements getCrawlWebResults(String crawlRequestToken) {
		Optional<WebCrawledElements> crawlResultResponse = crawlElementsMongoRepository.findById(crawlRequestToken);
		if (crawlResultResponse.isPresent()) {
			return crawlResultResponse.get();
		} else {
			throw new CrawlRequestNotFoundException(crawlRequestToken);
		}
	}

}
