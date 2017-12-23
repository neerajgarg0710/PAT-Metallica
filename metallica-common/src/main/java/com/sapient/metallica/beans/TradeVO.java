package com.sapient.metallica.beans;

public class TradeVO {

	private Long id;
	private String date;
	private String commodity;
	private String side;
	private String counterParty;
	private String location;
	private int quanity;
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

}
