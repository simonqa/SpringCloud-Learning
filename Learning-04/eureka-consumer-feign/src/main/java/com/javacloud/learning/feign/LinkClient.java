package com.javacloud.learning.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface LinkClient {

	@GetMapping("/link")
	public String consume();
}
