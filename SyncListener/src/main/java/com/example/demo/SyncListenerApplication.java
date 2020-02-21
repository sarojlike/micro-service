package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class SyncListenerApplication {
	
	@Value("${api.url}")
	private String url;
		@Autowired
		@Qualifier("serviceBean")
	    ServiceBean serviceBean;

		
		
	    @RequestMapping("/time")
	    public String todayTime(){
	        return serviceBean.getTime(url);
	    }
	    
		public static void main(String[] args) {
			SpringApplication.run(SyncListenerApplication.class, args);
		}

}
