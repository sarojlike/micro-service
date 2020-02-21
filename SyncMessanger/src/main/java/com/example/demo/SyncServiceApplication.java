package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SyncServiceApplication {

	 @RequestMapping("/getCurrentTime")
	    public Map<String, String> currentTime(){
	        Map<String,String> response=new HashMap<String, String>(){{
	            this.put("status","OK");
	            this.put("time","Today is "+new Date());
	        }};
	        return response;
	    }
	public static void main(String[] args) {
		SpringApplication.run(SyncServiceApplication.class, args);
	}

}
