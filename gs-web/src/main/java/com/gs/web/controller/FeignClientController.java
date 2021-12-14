package com.gs.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.web.client.EmployeeClient;
import com.gs.web.dto.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/feign")
public class FeignClientController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeClient empClient;
	
	@GetMapping("/list")
	public Object getEmpList() {
		logger.info("FeignClientController -> getEmplList() ");
		return empClient.getEmployees();
	}
	
	@PostMapping("/create")
	public Object createEmployee(@RequestBody Employee emp) {
		Object resEmp = empClient.createEmployee(emp);
		return resEmp;
	}
	
	
}
