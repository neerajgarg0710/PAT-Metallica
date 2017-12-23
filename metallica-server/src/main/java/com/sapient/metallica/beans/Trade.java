package com.sapient.metallica.beans;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.sapient.metallica.util.TestData;

public class Trade {

	@Id
	private Long tradeId;
	private Side side;
	private int quanity;
	private Double price;
	private Date tradeDate;
	private TradeStatus status;
	private Commodity commodity;
	private CounterParty counterParty;
	private Location location;

	public Trade() {
		this.tradeId = TestData.getNextTradeId();
		this.status = TradeStatus.OPEN;
	}

	public Trade(Side side, int quanity, Double price, Date tradeDate, TradeStatus status) {

		this.side = side;
		this.quanity = quanity;
		this.price = price;
		this.tradeDate = tradeDate;
		this.status = status;
		this.tradeId = TestData.getNextTradeId();
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
