package com.gs.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs.web.dto.Employee;

@FeignClient(url="http://localhost:8080", name="EMP-CLIENT", fallback = EmployeeClient.EmployeeClientFallBack.class)
public interface EmployeeClient {
	
	@GetMapping("/app/emp/list")
	public Object getEmployees();

	@PostMapping("/app/emp/create")
	public Object createEmployee(@RequestBody Employee emp);
	
	@GetMapping("/app/emp/byId/{id}")
	public Object getEmployeeById(@PathVariable("id") Long id);
	
	@Component
	public static class EmployeeClientFallBack implements EmployeeClient{

		@Override
		public Object getEmployees() {
			
			return new String("Employee Servicers are not working..");
		}

		@Override
		public Object createEmployee(Employee emp) {
			// TODO Auto-generated method stub
			return new String("Employee Servicers are not working..");
		}

		@Override
		public Object getEmployeeById(Long id) {
			// TODO Auto-generated method stub
			return new String("Employee Servicers are not working..");
		}
		
	}
	
	
		
}
