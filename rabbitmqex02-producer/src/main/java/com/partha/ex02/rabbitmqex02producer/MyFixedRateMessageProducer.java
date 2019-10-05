package com.partha.ex02.rabbitmqex02producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyFixedRateMessageProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate ;
	
	private int i =0;
	
	
	@Scheduled(fixedRate = 500)
	public void sendMessage(){
		i++;
		System.out.println("i is +"+i);
		rabbitTemplate.convertAndSend("myqueue01", "this is message"+i);
	}
	

}
