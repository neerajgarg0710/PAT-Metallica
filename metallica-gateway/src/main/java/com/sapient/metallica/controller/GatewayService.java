
package com.sapient.metallica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayService {

	@RequestMapping(value = "/ping")
	public String ping() {
		return "Gateway Service is UP and running";
	}

}
