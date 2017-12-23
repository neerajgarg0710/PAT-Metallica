package com.sapient.metallica.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MktDataController {

	@RequestMapping(value = "/ping")
	public String ping() {
		return "MktData Service is UP and running";
	}

}
