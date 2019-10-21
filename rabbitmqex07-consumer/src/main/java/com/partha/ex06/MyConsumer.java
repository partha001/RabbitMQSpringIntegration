package com.partha.ex06;

import java.io.IOException;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

@Component
public class MyConsumer {
	
	private ObjectMapper mapper = new ObjectMapper();

	@RabbitListener(queues="queue.image")
	public void consume(String message) throws JsonParseException, JsonMappingException, IOException{
		
			Image image = mapper.readValue(message, Image.class);
			if(image.getSize()>2001){
				//throw new IllegalArgumentException("image size exceeds processing limit");
				throw new AmqpRejectAndDontRequeueException("image size exceeds processing limit");
			}else{
				System.out.println("processed :"+ image.toString());
			}		
	}
	
	
//	@RabbitListener(queues="queue.image")
//	public void consume(Message message, Channel channel) throws JsonParseException, JsonMappingException, IOException{
//		
//			Image image = mapper.readValue(message.getBody(), Image.class);
//			if(image.getSize()>2001){
//				channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//			}else{
//				System.out.println("processed :"+ image.toString());
//			}
//			
//			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//	}
	

}
