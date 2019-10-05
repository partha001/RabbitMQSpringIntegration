package com.partha.ex02.rabbitmqex02producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * this example shows how a fixed rate producer works 
 * it also shows how messages are consumed by consumer at real time.
 * @author biswaspa
 *
 */
@EnableScheduling
@SpringBootApplication
public class Rabbitmqex02ProducerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Rabbitmqex02ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
