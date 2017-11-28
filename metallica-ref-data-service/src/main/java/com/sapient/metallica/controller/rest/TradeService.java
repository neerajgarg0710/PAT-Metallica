package com.sapient.metallica.controller.rest;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.sapient.metallica.util.MetallicaConstants;
import com.sapient.metallica.util.MetallicaUtil;
import com.sapient.metallica.util.TestData;

@RestController
@SpringBootApplication
public class TradeService {

	@RequestMapping(value = "/trades", method = RequestMethod.GET)
	public Collection<Trade> getAllTrades() {

		return TestData.getAllTrades();
	}

	@RequestMapping(value = "/trades", method = RequestMethod.POST)
	public void createTrade(@RequestBody TradeVO dto) {

		if (dto != null) {

			Trade trade = new Trade();
			trade.setCommodity(new Commodity(dto.getCommodity()));
			trade.setCounterParty(new CounterParty(dto.getCounterParty()));
			trade.setLocation(new Location(dto.getLocation()));
			trade.setPrice(dto.getPrice());
			trade.setQuanity(dto.getQuanity());
			trade.setSide(Side.valueOf(dto.getSide()));
			trade.setTradeDate(MetallicaUtil.parseDate(dto.getDate(), MetallicaConstants.DD_MM_YY));
			Map<Long, Trade> trades = TestData.getTradeMap();
			trades.put(trade.getTradeId(), trade);
		}
	}

	@RequestMapping(value = "/trades/{id}/{status}", method = RequestMethod.PUT)
	public void udpateTrade(@RequestParam Long id, @RequestParam String status) {

		Trade trade = TestData.getTrade(id);
		if (trade != null) {
			trade.setStatus(TradeStatus.valueOf(status));
		}
	}

	@RequestMapping(value = "/trades/search", method = RequestMethod.POST)
	public Collection<Trade> searchTrades(@RequestBody final TradeSearchVO dto) {
		Collection<Trade> trades = TestData.getAllTrades();

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
