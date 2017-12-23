package com.sapient.metallica.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MktDataListener {

	@RabbitListener(queues = "mdsQueue")
	public void receive(Long price) {
		System.out.println("Update");
		// if trade open push to UI
	}
}
