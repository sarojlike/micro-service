package com.example.demo;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@RabbitListener(queues="demo-queue")
public class AsyncListenerApplication {

	@Autowired
	@Qualifier("listenerService")
	private ListenerService listenerService;
	
	@RabbitHandler
	 public void listen(@Payload String content) { 
		  listenerService.processMessage(content); 
	}
	 
	
	public static void main(String[] args) {
		SpringApplication.run(AsyncListenerApplication.class, args);
	}

}
