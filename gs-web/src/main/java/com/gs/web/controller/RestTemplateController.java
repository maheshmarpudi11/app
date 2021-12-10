package com.gs.web.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gs.web.dto.Employee;
import com.gs.web.exception.RecordNotFoundException;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public ResponseEntity < Employee[] > getEmployees() {
			
		String URL = "http://localhost:8080/app/emp/list";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);

        ResponseEntity < Employee[] > apiResponse = restTemplate.exchange(URL, HttpMethod.GET, entity,Employee[].class);
        
        Employee[] emp = apiResponse.getBody();
        
        System.out.println(apiResponse);
        
        if(emp.length == 0) {
        	throw new RecordNotFoundException("resource is not avaliable..");
        }
        
        return  apiResponse;
	}
	
	@RequestMapping(value= "/byId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		
		String READ_BY_ID_URL = "http://localhost:8080/app/emp/byId/"+id;
		
		/*
		 * Map < String, Long > params = new HashMap < String, Long > ();
		 * params.put("id", id);
		 */

        RestTemplate restTemplate = new RestTemplate();
        Employee result = restTemplate.getForObject(READ_BY_ID_URL, Employee.class);
        
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * 
		 * HttpEntity < String > entity = new HttpEntity < String > ("parameters",
		 * headers);
		 * 
		 * ResponseEntity <Employee> apiResponse = restTemplate.exchange(READ_BY_ID_URL,
		 * HttpMethod.GET, entity,Employee.class,params);
		 */
        return new ResponseEntity<Employee>(result,HttpStatus.OK);
	}
	

}
