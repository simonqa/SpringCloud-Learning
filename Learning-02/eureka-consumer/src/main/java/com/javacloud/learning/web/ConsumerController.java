package com.javacloud.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/consume")
	public String consume() {
		// 获取服务提供方
		ServiceInstance client = loadBalancerClient.choose("eureka-client");
		// 组装服务地址
		String url = "http://" + client.getHost() + ":" + client.getPort() + "/link";
		System.out.println("服务地址:"+url);
		return restTemplate.getForObject(url, String.class);
	}
}
