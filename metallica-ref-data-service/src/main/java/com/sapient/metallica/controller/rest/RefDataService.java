package com.sapient.metallica.controller.rest;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.metallica.beans.Trade;

@RestController
@SpringBootApplication
public class RefDataService {

	@RequestMapping(value = "/getTradeDetails")
    public Trade getStudentDetails()
    {
        return new Trade(10, 1000d, new Date());
    }
	
	public static void main(String[] args)
    {
        SpringApplication.run(RefDataService.class, args);
    }
	
}
