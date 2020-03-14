package com.manishsonava.tSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manishsonava.tSystem.model.WebCrawledElements;

/**
 * CrawlElementsMongoRepository class manages web crawl elements collection.
 * @author Manish Sonava
 *
 */
@Repository
public interface CrawlElementsMongoRepository extends MongoRepository<WebCrawledElements, String> {
	
}

