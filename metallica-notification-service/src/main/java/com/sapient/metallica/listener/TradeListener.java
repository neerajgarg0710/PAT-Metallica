package com.sapient.metallica.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class TradeListener {

	@RabbitListener(queues = "tradeServiceQueue")
	public void receive(Long tradeId) {
		System.out.println("Created");
		// if trade open push to UI
	}
}
