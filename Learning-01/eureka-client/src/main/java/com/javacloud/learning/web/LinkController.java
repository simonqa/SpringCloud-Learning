package com.javacloud.learning.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

	
	@GetMapping("/link")
    public String link() {
        System.out.println("eureka-client-test");
        return "";
    }
}
