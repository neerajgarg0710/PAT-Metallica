
package com.sapient.metallica.configration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sapient.metallica.service.MktDataService;

@Configuration
public class MktDataServiceConfig {

	@Bean
	TopicExchange tradeExchange() {
		return new TopicExchange("metallicaExchange");
	}

	@Bean
	public MktDataService tradeService(RabbitTemplate rabbitTemplate, TopicExchange tradeExchange) {
		return new MktDataService(rabbitTemplate, tradeExchange);
	}

	@Bean
	public Queue queue() {
		return new Queue("mdsQueue");
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange tradeExchange) {
		return BindingBuilder.bind(queue).to(tradeExchange).with("rt.price");
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
