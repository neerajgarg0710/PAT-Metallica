package com.sapient.metallica.beans;

import java.util.Date;

public class Trade {

    int quanity;
    double price;
    Date tradeDate;
   
	public Trade(int quanity, double price, Date tradeDate) {
		super();
		this.quanity = quanity;
		this.price = price;
		this.tradeDate = tradeDate;
	}
	
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
      
}
