package com.manishsonava.tSystem.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.manishsonava.tSystem.model.CrawlResponse;
import com.manishsonava.tSystem.model.CrawlStatus;
import com.manishsonava.tSystem.model.LinkType;
import com.manishsonava.tSystem.model.Page;
import com.manishsonava.tSystem.model.SiteData;
import com.manishsonava.tSystem.model.WebCrawledElements;
import com.manishsonava.tSystem.repository.CrawlElementsMongoRepository;
import com.manishsonava.tSystem.repository.CrawlMongoRepository;
import com.manishsonava.tSystem.service.WebCrawlerService;
import com.manishsonava.tSystem.service.reducer.WebCrawlerDataReducer;

/**
 * WebCrawlerScheduler class to schedule the crawling jobs.
 * @author Manish Sonava
 *
 */
@Component
public class WebCrawlerScheduler {

	@Autowired
	private CrawlMongoRepository crawlMongoRepository;
	
	@Autowired
	private CrawlElementsMongoRepository crawlElementsMongoRepository;

	@Autowired
	private WebCrawlerService webCrawlerService;
	
	@Autowired
	private WebCrawlerDataReducer webCrawlerDataReducer;

	/**
	 * Method to read the submited/failed jobs and scan the page for the cralwed results. 
	 */
	@Async
	@Scheduled(fixedRateString = "${crawler.job.interval}")
	public void scheduleFixedRateTaskAsync() { // the task here can be moved to a service.
		List<String> requestStatus = new ArrayList<>();
		requestStatus.add(CrawlStatus.SUBMITTED.name());
		requestStatus.add(CrawlStatus.FAILED.name());
		List<CrawlResponse> requests = crawlMongoRepository.findByStatusIn(requestStatus);

		requests.parallelStream().forEach(request -> {

			// check failed attenpts for a request. if more than threshold say 3. ignore the
			// request. - Not implementing
			request.setStatus(CrawlStatus.IN_PROGRESS);
			crawlMongoRepository.save(request);

			List<Page> crawledPages = new ArrayList<>();
			Page page = webCrawlerService.getCrawledSiteData(request.getCrawlRequest().getBaseURL());
			crawledPages.add(page);
			int currentDepth = request.getCrawlRequest().getDepth() - 1;
			for(int count = 0; count< page.getSiteDatas().size() && request.getCrawlRequest().getDepth() >= currentDepth; count++ ) { // used  loop. could have used copyonwritearraylist as well. which would avoided this.
				SiteData siteData = page.getSiteDatas().get(count);
				if(LinkType.LINK.equals(siteData.getLinkType())) {
					Page newPage = webCrawlerService.getCrawledSiteData(siteData.getLink());
					crawledPages.add(newPage);
					page.getSiteDatas().addAll(newPage.getSiteDatas());
				}
				request.getCrawlRequest().setDepth(request.getCrawlRequest().getDepth() - 1);
			}
			
			// call reducer on crawledSiteDatas.
			WebCrawledElements webCrawledElements =  webCrawlerDataReducer.mapCrawledElements(crawledPages, request.getToken());
			webCrawledElements.setToken(request.getToken());
			
			request.setStatus(CrawlStatus.READY);
			crawlMongoRepository.save(request);
			crawlElementsMongoRepository.save(webCrawledElements);

		});
	}

}
