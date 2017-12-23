package com.sapient.metallica.configration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sapient.metallica.service.TradeService;
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
	    return new Queue("tradeServiceQueue");
	  }

	  @Bean
	  public Binding binding(Queue queue, TopicExchange tradeExchange) {
	    return BindingBuilder.bind(queue).to(tradeExchange).with("trade.*");
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
