package com.sapient.metallica.controller.rest;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.metallica.beans.Commodity;
import com.sapient.metallica.beans.CounterParty;
import com.sapient.metallica.beans.Location;
import com.sapient.metallica.beans.Side;
import com.sapient.metallica.beans.Trade;
import com.sapient.metallica.beans.TradeSearchVO;
import com.sapient.metallica.beans.TradeStatus;
import com.sapient.metallica.beans.TradeVO;
import com.sapient.metallica.message.TradeService;
import com.sapient.metallica.repository.TradeRepository;
import com.sapient.metallica.util.MetallicaConstants;
import com.sapient.metallica.util.MetallicaUtil;
import com.sapient.metallica.util.TestData;

@RestController
@SpringBootApplication
public class TradeController {
	
	@Autowired
	private TradeRepository repository;
	
	@Autowired
	private TradeService tradeService;

	@RequestMapping(value = "/trades", method = RequestMethod.GET)
	public Collection<Trade> getAllTrades() {
		
		return repository.findAll();
	}

	@RequestMapping(value = "/trades", method = RequestMethod.POST)
	public void createTrade(@RequestBody TradeVO dto) {

		
		if (dto != null) {
			tradeService.createTrade(dto);
		}
	}

	@RequestMapping(value = "/trades/{id}/{status}", method = RequestMethod.PUT)
	public void udpateTrade(@RequestParam Long id, @RequestParam String status) {

		//TODO:
	}

	@RequestMapping(value = "/trades/search", method = RequestMethod.POST)
	public Collection<Trade> searchTrades(@RequestBody final TradeSearchVO dto) {
		Collection<Trade> trades = repository.findAll();

		List<Trade> tradeList = trades.stream().filter(trade -> isMeetSearchCrietria(dto, trade))
				.collect(Collectors.toList());

		return tradeList;
	}

	private boolean isMeetSearchCrietria(TradeSearchVO tradeVo, Trade trade) {
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
			if (tradeVo.getSides() != null && !tradeVo.getSides().contains(trade.getSide().name())) {
				return false;
			}
			return true;
		}
		return false;
	}
}
