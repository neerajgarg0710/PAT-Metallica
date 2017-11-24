package com.sapient.metallica.controller.rest;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.metallica.beans.Commodity;
import com.sapient.metallica.beans.CounterParty;
import com.sapient.metallica.beans.Location;
import com.sapient.metallica.util.TestData;

@RestController
@SpringBootApplication
public class PingService {

	
	
	@RequestMapping(value = "/ping")
    public String ping()
    {
      return "Server is UP and running";
    }
	
	
}
