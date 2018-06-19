package com.javacloud.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacloud.learning.service.IConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	private IConsumerService consumerService;
	
	@GetMapping("/consumer")
    public String dc() {
        return consumerService.consume();
    }
	
}
