package com.partha.ex01.rabbitmq.ex01;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
	
	@RabbitListener(queues = "myqueue01")
	public void listen(String message){
		System.out.println("message received . message: "+message);
	}

}
