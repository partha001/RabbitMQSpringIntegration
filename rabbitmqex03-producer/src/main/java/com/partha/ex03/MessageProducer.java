package com.partha.ex03;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer implements CommandLineRunner{
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void run(String... args) throws Exception {
		
		//using the below method will post the message directly onto the queue without using exchnge
		//rabbitTemplate.convertAndSend("myqueue03", "this is the first message");
		
		rabbitTemplate.convertAndSend("myexchange03", "test", "this is the firstmessage");
	}

}
