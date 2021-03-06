package com.sapient.metallica.configration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sapient.metallica.message.TradeListener;
import com.sapient.metallica.message.TradeService;
@Configuration
public class TradeServiceConfig {
	

	@Bean
	TopicExchange tradeExchange() {
		return new TopicExchange("metallicaExchange");
	}
	
	@Bean
	 public TradeService tradeService(RabbitTemplate rabbitTemplate, TopicExchange tradeExchange) {
	   return new TradeService(rabbitTemplate, tradeExchange);
	 }

	
	
	  @Bean
	  public Queue queue() {
	    return new Queue("tradeQueue");
	  }

	  @Bean
	  public Binding binding(Queue queue, TopicExchange tradeExchange) {
	    return BindingBuilder.bind(queue).to(tradeExchange).with("trade.*");
	  }

	  @Bean
	  public TradeListener eventReceiver() {
	    return new TradeListener();
	  }
	  
	  @Bean
	  public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	                                                  MessageListenerAdapter listenerAdapter) {
	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames("tradeQueue");
	    container.setMessageListener(listenerAdapter);
	    return container;
	  }

	  @Bean
	  public MessageListenerAdapter listenerAdapter(TradeListener eventSubscriber) {
	    return new MessageListenerAdapter(eventSubscriber, "receive");
	  }

	  
}
