package com.example.demo;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component("listenerService")
public class ListenerService {
	public void processMessage(@Payload String content) {
		System.out.println("Message Recived "+content);
	}
	
}
