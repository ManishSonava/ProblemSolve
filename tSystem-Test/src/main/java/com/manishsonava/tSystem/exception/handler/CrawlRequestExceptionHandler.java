package com.manishsonava.tSystem.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.manishsonava.tSystem.exception.CrawlRequestNotFoundException;
import com.manishsonava.tSystem.model.CrawlResponse;
import com.manishsonava.tSystem.model.Errors;

/**
 * CrawlRequestExceptionHandler class to handle the exception thrown by the application.
 * @author Manish Sonava
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class CrawlRequestExceptionHandler {

	/**
	 * Method to handle CrawlRequestNotFoundException exception thrown when requested token is not found. 
	 * @param crawlRequestNotFoundException
	 * @return
	 */
	@ExceptionHandler(CrawlRequestNotFoundException.class)
	public CrawlResponse returnErrorResponse(CrawlRequestNotFoundException crawlRequestNotFoundException) {
		CrawlResponse crawlResponse = new CrawlResponse();
		Errors error = new Errors();
		error.setCode("ERR:Not-FOUND");
		error.setMessage(crawlRequestNotFoundException.getToken() + " not found");
		List<Errors> errors = new ArrayList<>();
		errors.add(error);
		crawlResponse.setErrors(errors);
		return crawlResponse;
	}

}
