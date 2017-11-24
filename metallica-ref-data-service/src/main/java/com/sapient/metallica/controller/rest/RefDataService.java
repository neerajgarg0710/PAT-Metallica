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
import com.sapient.metallica.beans.TradeDTO;
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

	@RequestMapping(value = "/trades", method = RequestMethod.POST)
	public Collection<Trade> searchTrades(@RequestBody final TradeDTO dto) {
		Collection<Trade> trades = TestData.getTrades();

		List<Trade> tradeList = trades.stream().filter(trade -> isMeetSearchCrietria(dto, trade))
				.collect(Collectors.toList());

		return tradeList;
	}

	private boolean isMeetSearchCrietria(TradeDTO tradeVo, Trade trade) {
		if (trade != null && tradeVo != null) {
			if (tradeVo.getCommodity() != null && !tradeVo.getCommodity().equals(trade.getCommodity().getCode())) {
				return false;
			}
			if (tradeVo.getCounterParty() != null
					&& !tradeVo.getCounterParty().equals(trade.getCounterParty().getCode())) {
				return false;
			}
			if (tradeVo.getLocation() != null && !tradeVo.getLocation().equals(trade.getLocation().getCode())) {
				return false;
			}
			if (tradeVo.getFromDate() != null && tradeVo.getFromDate().before(trade.getTradeDate())) {
				return false;
			}
			if (tradeVo.getToDate() != null && tradeVo.getToDate().after(trade.getTradeDate())) {
				return false;
			}
			if(tradeVo.getSides()!=null && !tradeVo.getSides().contains(trade.getSide().name())){
				return false;
			}
			return true;
		}
		return false;
	}

}
