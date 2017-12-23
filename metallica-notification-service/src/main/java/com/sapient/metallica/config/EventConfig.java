package com.sapient.metallica.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.sapient.metallica.listener.TradeListener;

@Configuration
public class EventConfig implements RabbitListenerConfigurer {

	/*@Bean
	public TopicExchange eventExchange() {
		return new TopicExchange("metallicaExchange");
	}

	@Bean
	public Queue queue() {
		return new Queue("tradeServiceQueue");
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange eventExchange) {
		return BindingBuilder.bind(queue).to(eventExchange).with("trade.*");
	}*/

	@Bean
	public TradeListener eventReceiver() {
		return new TradeListener();
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());

	}

	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

}