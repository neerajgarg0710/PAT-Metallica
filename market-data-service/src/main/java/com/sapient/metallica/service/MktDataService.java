package com.sapient.metallica.service;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.sapient.metallica.util.MetallicaConstants;

@Service
public class MktDataService {

	private final RabbitTemplate rabbitTemplate;

	private final TopicExchange exchange;

	public MktDataService(RabbitTemplate rabbitTemplate, TopicExchange exchange) {
		this.rabbitTemplate = rabbitTemplate;
		this.exchange = exchange;
	}

	public void updatePrice() {
		//Logic to update price for each ticker
		rabbitTemplate.convertAndSend(exchange.getName(), MetallicaConstants.RT_PRICE, 100);
	}

}
