package com.cosmin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ReadPropertiesController {
	@Value("${config-1.min}")
	private String min;
	
	@PostConstruct
	private void init() {
		log.info("config-1.min=" + min);
	}
	
	@GetMapping("/config")
	public ResponseEntity<String> config(@Value("${config-1.min}") String min)
	{
		String resp = "config-1.min=" + min;
		log.info("config-1.min=" + resp);
	    return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}
