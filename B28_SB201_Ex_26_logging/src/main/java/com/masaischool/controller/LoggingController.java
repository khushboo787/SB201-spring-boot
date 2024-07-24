package com.masaischool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/logging")
public class LoggingController {
	//step-01: Get the object for Logging messages for this class
	Logger logger = LoggerFactory.getLogger(LoggingController.class);
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		//step-02: Write the log messages
		logger.trace("This is a trace message");
		logger.debug("This is a debug message");
		logger.info("This is a info message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
		
		return new ResponseEntity<String>("Simple Logging Example", HttpStatus.OK);
	}
}
