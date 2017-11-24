package com.sapient.metallica.beans;

import java.sql.Date;
import java.util.List;

public class TradeVO {

	private Date fromDate;
	private Date toDate;
	private String commodity;
	private List<String> sides;
	private String counterParty;
	private String location;
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public List<String> getSides() {
		return sides;
	}
	public void setSides(List<String> sides) {
		this.sides = sides;
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
	
}
