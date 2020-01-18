package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloserviceApplication {
	
	@RequestMapping("/")
	public Map<String, String> hello() {
		HashMap<String, String> response = new HashMap<String,String>(){{
			this.put("status", "OK");
			this.put("message", "Hello user");
		}};
		return response;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(HelloserviceApplication.class, args);
	}

}
