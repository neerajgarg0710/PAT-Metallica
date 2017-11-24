package com.sapient.metallica.beans;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Trade {

	private Long tradeId;
	private Side side;
	private int quanity;
	private Double price;
	private Date tradeDate;
	private TradeStatus status;
	private Commodity commodity;
	private CounterParty counterParty;
	private Location location;

	private static AtomicLong tradeIdVal = new AtomicLong(1101);

	public Trade(Side side, int quanity, Double price, Date tradeDate, TradeStatus status) {

		this.side = side;
		this.quanity = quanity;
		this.price = price;
		this.tradeDate = tradeDate;
		this.status = status;
		this.tradeId = tradeIdVal.getAndIncrement();
	}

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public TradeStatus getStatus() {
		return status;
	}

	public void setStatus(TradeStatus status) {
		this.status = status;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public CounterParty getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(CounterParty counterParty) {
		this.counterParty = counterParty;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
