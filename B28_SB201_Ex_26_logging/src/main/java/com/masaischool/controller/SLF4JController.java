package com.masaischool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/slf4j")
@Slf4j	//this will automatically create an object name 'log' that will be used to log the messages
//@Slf4j = private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
public class SLF4JController {
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		//step-02: Write the log messages
		log.trace("This is a @Slf4j:trace message");
		log.debug("This is a @Slf4j:debug message");
		log.info("This is a @Slf4j:info message");
		log.warn("This is a @Slf4j:warn message");
		log.error("This is a @Slf4j:error message");
		
		return new ResponseEntity<String>("Simple Logging Example", HttpStatus.OK);
	}
}
