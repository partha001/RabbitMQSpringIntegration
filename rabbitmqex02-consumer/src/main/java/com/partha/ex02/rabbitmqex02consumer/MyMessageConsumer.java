package com.partha.ex02.rabbitmqex02consumer;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MyMessageConsumer {
	
	//@RabbitListener(queues="myqueue01",concurrency = "3")
	@RabbitListener(queues="myqueue01")
	public void consumeMessage(String message) throws InterruptedException{
		//Thread.sleep(1000);
		System.out.println("consuming message:"+ message);
		
		
		//new Thread(new MyTask(message)).start();
		
		//System.out.println("consuming: "+message+"  on thread:"+Thread.currentThread().getName());
		//Thread.currentThread().sleep(1000);
		
	}
	
	
//	public static class MyTask implements Runnable {
//		
//		String input;
//		
//		public MyTask(String input) {
//			super();
//			this.input = input;
//		}
//
//		@Override
//		public void run() {
//			try {
//				TimeUnit.MICROSECONDS.sleep(1000);
//				System.out.println("consuming message:"+ input);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
	

}
