package com.sapient.metallica;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sapient.metallica.message.Receiver;




@SpringBootApplication
public class MetallicaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetallicaServiceApplication.class, args);
	}

	public static final String queueName="metallica-queue";
	
	@Bean
	Queue queue(){
		return new Queue(queueName, false);
	}
	
	@Bean
	TopicExchange exchange(){
		return new TopicExchange("metallica-exchange");
	}
	
	@Bean 
	Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListener messageListener){
		SimpleMessageListenerContainer msgContainer = new SimpleMessageListenerContainer();
		msgContainer.setConnectionFactory(connectionFactory);
		msgContainer.setMessageListener(messageListener);
		msgContainer.setQueueNames(queueName);
		return msgContainer;		
	}
	
	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver){
		return new MessageListenerAdapter(receiver, "receiveMessage");			
	}
}