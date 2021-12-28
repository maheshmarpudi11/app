package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/")
	@ResponseBody
	public String homepage() {
		return "welcome to homepage..";
	}
	
	@GetMapping("/api")
	@ResponseBody
	public String apiCall() {
		
		String url = "http://localhost:8080/api/data";
		String apiResponse = null;
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic YXBpdXNlcjphcGl1c2VyMTIz");

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> response = template.exchange(
		    url, HttpMethod.GET, requestEntity, String.class);

		if(response.getBody() != null)
			apiResponse = response.getBody();
		
		return apiResponse;
	}
	
	@GetMapping("/admin/createStudent")
	@ResponseBody
	public String createStudent() {
		return "student is created..";
	}

	@GetMapping("/user/updateStudent")
	@ResponseBody
	public String updateStudent() {
		return "student is updated..";
	}
	
	@GetMapping("/readStudent")
	@ResponseBody
	public String readStudent() {
		return "student are able to read..";
	}
	
	
}
