package com.example.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("serviceBean")
public class ServiceBean {


    @Autowired
    private RestTemplate restTemplate;
   
    
    
    @Bean
    RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "fallBackResponse")
    public String getTime(String url) {
        URI uri= URI.create(url);
        String string = this.restTemplate.getForObject(uri,String.class).toString();
        return string;
    }


	
	  public String fallBackResponse(String url){ 
		  return "Today time is not avaialble"; 
		 }
	 
}
