package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloserviceApplication {
	
	@Value("${hello.message}")
	private String message;
	
	
	@Value("${hi.message2}") 
	private String message2;
	 
	
	@RequestMapping("/hellomessage")
	public Map<String, String> hello() {
		HashMap<String, String> response = new HashMap<String,String>(){{
			this.put("status", "OK");
			this.put("message", message);
		}};
		return response;
	}
	
	
	  @RequestMapping("/hi") 
	  public Map<String, String> sayHi() { 
		  HashMap<String,String> response = new HashMap<String,String>(){{ 
				  this.put("status", "OK");	  
				  this.put("message", message2); 
			  }}; 
		return response; 
	}
	 
	

	public static void main(String[] args) {
		SpringApplication.run(HelloserviceApplication.class, args);
	}

}
