package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AsyncMessangerApplication {
	@Autowired
	@Qualifier("sendingService")
	private SendingService sendingService;
	
	@RequestMapping(value="/send/{message}" ,produces="application/json")
	public Map<String,String> sendMessage(@PathVariable String message ) {
		return sendingService.sendMessage(message);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(AsyncMessangerApplication.class, args);
	}
	

}
