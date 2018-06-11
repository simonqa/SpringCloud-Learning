package com.javacloud.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacloud.learning.feign.LinkClient;

@RestController
public class ConsumerController {

	@Autowired
	private LinkClient linkClient;

	@GetMapping(value = "/consume")
	public String consume() {
		return linkClient.consume();
	}
}
