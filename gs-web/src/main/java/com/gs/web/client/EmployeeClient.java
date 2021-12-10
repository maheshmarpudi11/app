package com.gs.web.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs.web.dto.Employee;

@FeignClient(url="http://localhost:8080", name="EMP-CLIENT")
public interface EmployeeClient {
	
	@GetMapping("/app/emp/list")
	public List<Employee> getEmployees();

	@PostMapping("/app/emp/create")
	public Employee createEmployee(@RequestBody Employee emp);
	
	@GetMapping("/app/emp/byId/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id);
	
	
}
