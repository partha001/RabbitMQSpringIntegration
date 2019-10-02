package com.partha.rabbitmqex01producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Rabbitmqex01ProducerApplication implements CommandLineRunner{

	@Autowired
	private MyRabbitMQProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(Rabbitmqex01ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendMessage("Hello RabbitMQ");
	}

}
