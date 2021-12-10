package com.gs.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class GsWebApplication implements CommandLineRunner {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public ResponseEntity < Employee[] > getEmployees() {
			
		String URL = "http://localhost:8080/app/emp/list";
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);

        ResponseEntity < Employee[] > apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity,Employee[].class);
        
        Employee[] emp = apiResponse.getBody();
        
        
        if(emp.length == 0) {
        	throw new RuntimeException("resource is not avaliable..");
        }
        
        return  apiResponse;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//getEmployees();
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(GsWebApplication.class, args);
	}
		
	@ExceptionHandler({Exception.class,RuntimeException.class})
	public ResponseEntity<Object> handleException(Exception ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.OK);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
