package com.partha.ex04;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * this class is to demonstrate how binary messages can be send. just 
 * @author biswaspa
 *
 */
//@Service
public class MessageProducer implements CommandLineRunner {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;


	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee(1, "partha");
		rabbitTemplate.convertAndSend("myexchange03", "test", emp);
		
	}
	

}
