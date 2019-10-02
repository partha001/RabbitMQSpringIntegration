package com.partha.rabbitmqex01producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyRabbitMQProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String message){
		rabbitTemplate.convertAndSend("myqueue01",message);
	}

}
