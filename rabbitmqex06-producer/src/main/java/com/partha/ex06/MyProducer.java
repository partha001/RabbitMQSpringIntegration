package com.partha.ex06;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyProducer implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate ;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee(1,"partha biswas");
		String json = null ;
		try{
			json = objectMapper.writeValueAsString(emp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		rabbitTemplate.convertAndSend("myqueue01", json);
	}

}
