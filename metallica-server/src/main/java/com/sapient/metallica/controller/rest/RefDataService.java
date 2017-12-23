package com.sapient.metallica.controller.rest;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.metallica.beans.Commodity;
import com.sapient.metallica.beans.CounterParty;
import com.sapient.metallica.beans.Location;
import com.sapient.metallica.beans.Trade;
import com.sapient.metallica.beans.TradeSearchVO;
import com.sapient.metallica.util.TestData;

@RestController
@SpringBootApplication
public class RefDataService {

	@RequestMapping(value = "/counterparties")
	public Collection<CounterParty> getCounterParties() {
		return TestData.getCounterParties();
	}

	@RequestMapping(value = "/locations")
	public Collection<Location> getLocations() {
		return TestData.getLocations();
	}

	@RequestMapping(value = "/commodities")
	public Collection<Commodity> getCommodities() {
		return TestData.getCommodities();
	}

}
