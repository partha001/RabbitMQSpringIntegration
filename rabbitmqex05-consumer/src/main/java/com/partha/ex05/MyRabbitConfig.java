package com.partha.ex05;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitConfig {
	
	private static final String QUEUE_NAME = "myqueue04";
	
	@Bean
	Queue myQueue(){
		return new Queue(QUEUE_NAME,true);
	}
	
	@Bean 
	Queue mySecondQueue(){
		return QueueBuilder.durable("myqueue05")
				.autoDelete()
				.exclusive()
				.build();
	}
	
	
	@Bean
	ConnectionFactory connectionFactory(){
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost", 5672);
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		return cachingConnectionFactory;
	}
	
	
	@Bean
	MessageListenerContainer messageListenerContainer(){
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(myQueue());
		simpleMessageListenerContainer.setMessageListener(new MyMessageListener());
		return simpleMessageListenerContainer;
	}

}
