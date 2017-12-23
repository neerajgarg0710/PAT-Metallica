package com.sapient.metallica.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.sapient.metallica.beans.Commodity;
import com.sapient.metallica.beans.CounterParty;
import com.sapient.metallica.beans.Location;
import com.sapient.metallica.beans.Side;
import com.sapient.metallica.beans.Trade;
import com.sapient.metallica.beans.TradeStatus;

public class TestData {

	private static Map<Long, Trade> trades = new ConcurrentHashMap<>();
	public static AtomicLong tradeIdVal = new AtomicLong(1101);

	static {

		Trade t1 = new Trade(Side.BUY, 50, 100.00, new Date(2017, 10, 20), TradeStatus.OPEN);
		t1.setCommodity(new Commodity("AL", "Aluminum"));
		t1.setCounterParty(new CounterParty("Lorem", "Lorem"));
		t1.setLocation(new Location("LN", "London"));

		Trade t2 = new Trade(Side.SELL, 50, 100.00, new Date(2017, 10, 20), TradeStatus.NOMINATED);
		t2.setCommodity(new Commodity("AL", "Aluminum"));
		t2.setCounterParty(new CounterParty("Lorem", "Lorem"));
		t2.setLocation(new Location("LN", "London"));

		Trade t3 = new Trade(Side.SELL, 30, 125.00, new Date(2017, 10, 21), TradeStatus.OPEN);
		t3.setCommodity(new Commodity("AL", "Aluminum"));
		t3.setCounterParty(new CounterParty("Lorem", "Lorem"));
		t3.setLocation(new Location("LN", "London"));

		Trade t4 = new Trade(Side.BUY, 20, 140.00, new Date(2017, 10, 20), TradeStatus.OPEN);
		t4.setCommodity(new Commodity("ZN", "Zinc"));
		t4.setCounterParty(new CounterParty("Ipsum", "Ipsum"));
		t4.setLocation(new Location("NY", "New York"));

		Trade t5 = new Trade(Side.BUY, 10, 160.00, new Date(2017, 10, 21), TradeStatus.OPEN);
		t5.setCommodity(new Commodity("ZN", "Zinc"));
		t5.setCounterParty(new CounterParty("Dolor", "Dolor"));
		t5.setLocation(new Location("NY", "New York"));

		trades.put(t1.getTradeId(), t1);
		trades.put(t2.getTradeId(), t2);
		trades.put(t3.getTradeId(), t3);
		trades.put(t4.getTradeId(), t4);
		trades.put(t5.getTradeId(), t5);

	}

	public static Long getNextTradeId() {

		return tradeIdVal.getAndIncrement();
	}

	public static Collection<Trade> getAllTrades() {

		return trades.values();
	}

	public static Collection<Commodity> getCommodities() {

		Commodity c1 = new Commodity("AL", "Aluminum");
		Commodity c2 = new Commodity("ZN", "Zinc");
		Commodity c3 = new Commodity("CU", "Copper");
		Commodity c4 = new Commodity("AU", "Gold");
		Commodity c5 = new Commodity("AG", "Silver");

		List<Commodity> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);

		return list;
	}

	public static Collection<CounterParty> getCounterParties() {

		CounterParty c1 = new CounterParty("Lorem", "Lorem");
		CounterParty c2 = new CounterParty("Ipsum", "Ipsum");
		CounterParty c3 = new CounterParty("Dolor", "Dolor");
		CounterParty c4 = new CounterParty("Amet", "Amet");

		List<CounterParty> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);

		return list;
	}

	public static Collection<Location> getLocations() {

		Location c1 = new Location("LN", "London");
		Location c2 = new Location("NY", "New York");
		Location c3 = new Location("SG", "Singapore");
		Location c4 = new Location("DN", "Denver");

		List<Location> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);

		return list;
	}

	public static Map<Long, Trade> getTradeMap() {
		return trades;
	}

	public static Trade getTrade(Long id) {
		return trades.get(id);
	}
}
