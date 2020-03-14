package com.manishsonava.tSystem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manishsonava.tSystem.model.CrawlResponse;

/**
 * CrawlMongoRepository manages crawl response collection.
 * @author Manish Sonava
 *
 */
@Repository
public interface CrawlMongoRepository extends MongoRepository<CrawlResponse, String> {
	List<CrawlResponse> findByStatusIn(List<String> status);
}