package com.partha.ex06;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyListener {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RabbitListener(queues = "myqueue01")
	public void listen(String message){
		try {
			Employee emp = mapper.readValue(message, Employee.class);
			System.out.println("empid: "+emp.getId()+ "  empname: "+emp.getName());
		} catch (JsonParseException|JsonMappingException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("message received . message: "+message);
	}

}
