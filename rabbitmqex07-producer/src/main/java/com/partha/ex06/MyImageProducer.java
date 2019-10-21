package com.partha.ex06;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyImageProducer implements CommandLineRunner{
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void run(String... args) throws Exception {
		for(int i=1;i<=2;i++){
			Image image = new Image("image00"+i , "jpg" , 2000+i);
			String json = mapper.writeValueAsString(image);
			rabbitTemplate.convertAndSend("exchange.image", "", json);
		}
	}

}
