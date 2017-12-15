package com.sapient.metallica.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.sapient.metallica.beans.Trade;

public class TradeListener {

	

	  @RabbitListener(queues="tradeServiceQueue")
	  public void receive(Trade trade) {
	   
	  }
}
