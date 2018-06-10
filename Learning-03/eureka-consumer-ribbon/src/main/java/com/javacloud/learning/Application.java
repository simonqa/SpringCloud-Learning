package com.javacloud.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.javacloud.learning.config.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="eureka-client",configuration=RibbonConfiguration.class)
public class Application {
	
	@Bean
	@LoadBalanced // 添加负载均衡支持
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
