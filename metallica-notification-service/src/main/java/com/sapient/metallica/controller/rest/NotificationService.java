package com.sapient.metallica.controller.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class NotificationService {

	@RequestMapping(value = "/ping")
	public String ping() {
		return "RefData Service is UP and running";
	}
	


}
