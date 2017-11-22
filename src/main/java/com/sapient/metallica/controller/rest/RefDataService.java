package com.sapient.metallica.controller.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.metallica.beans.Trade;

@RestController
public class RefDataService {

	@RequestMapping(value = "/getTradeDetails")
    public Trade getStudentDetails(@PathVariable(name = "name") String name)
    {
        return new Trade(10, 1000d, new Date());
    }
	
}
