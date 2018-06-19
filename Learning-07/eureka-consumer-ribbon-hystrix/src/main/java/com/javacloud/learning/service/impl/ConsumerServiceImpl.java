package com.javacloud.learning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javacloud.learning.service.IConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerServiceImpl implements IConsumerService{

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback")
	public String consume() {
		return restTemplate.getForObject("http://eureka-client/link", String.class);
	}
	
	public String fallback() {
        return "fallback";
    }

}
