package com.sapient.metallica.beans;

import java.sql.Date;
import java.util.List;

public class TradeSearchVO {

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodity == null) ? 0 : commodity.hashCode());
		result = prime * result + ((counterParty == null) ? 0 : counterParty.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((sides == null) ? 0 : sides.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeSearchVO other = (TradeSearchVO) obj;
		if (commodity == null) {
			if (other.commodity != null)
				return false;
		} else if (!commodity.equals(other.commodity))
			return false;
		if (counterParty == null) {
			if (other.counterParty != null)
				return false;
		} else if (!counterParty.equals(other.counterParty))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (sides == null) {
			if (other.sides != null)
				return false;
		} else if (!sides.equals(other.sides))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}
	
}
