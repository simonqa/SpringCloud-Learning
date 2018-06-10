package com.javacloud.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/consume")
	public String consume() {
		return restTemplate.getForObject("http://eureka-client/link", String.class);
	}
}
