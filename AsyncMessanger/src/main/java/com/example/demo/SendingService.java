package com.example.demo;

import java.util.HashMap;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component("sendingService")
public class SendingService {

	
	private final AmqpTemplate amqpTemplate;
	
	public SendingService( AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}
	
	@SuppressWarnings("serial")
	public HashMap<String, String> sendMessage(String messageString) {
		this.amqpTemplate.convertAndSend("demo-queue",messageString);
		return new HashMap<String,String>(){{
			this.put("message", "Message "+messageString+" has been sent");
		}};
	}
	
	
}
