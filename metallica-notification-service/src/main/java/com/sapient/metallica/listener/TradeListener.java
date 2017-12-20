package com.sapient.metallica.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.sapient.metallica.beans.Trade;

public class TradeListener {

	

	  @RabbitListener(queues="tradeServiceQueue")
	  public void receive(Trade trade) {
	   System.out.println("Created");
	   // if trade open push to UI
	  }
}
